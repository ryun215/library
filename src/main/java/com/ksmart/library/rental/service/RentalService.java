package com.ksmart.library.rental.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ksmart.library.dto.RentalDto;
import com.ksmart.library.dto.ReturnDto;

@Service
public class RentalService {
	private static final Logger logger = LoggerFactory.getLogger(RentalService.class);
	@Autowired
	private RentalDao rentalDao;
	//�ݳ��κ�
	//�����ڵ� �Է¹����� �����ڵ�� �뿩���� ��ȸ
	//��ȸ�� �뿩�������� memberId�� ������ �ش����� level�� �ش��ϴ� payment�������
	// 
	
	
	
	
	//�����ڵ�� �뿩���� ��ȸ
	public ReturnDto rentalInfoSelect(String bookCode){
		ReturnDto rent = rentalDao.rentalInfoSelect(bookCode);
		//ReturnDto Ÿ������ �� �޾ƿ�
		System.out.println(rent.toString());
		
		//�뿩�� String���� ������ DateŸ������ ��ȯ�Ͽ� ���糯¥-�뿩�� ���
		String rentalStart = rent.getRentalStart();
		System.out.println("�뿩������ ������ : "+rentalStart.toString());
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date startDay = null;
		try {
			startDay = format.parse(rentalStart);
			System.out.println("startDay :"+startDay);
		} catch (ParseException e) {
		
			e.printStackTrace();
		}
		Date currentDay = new Date();
		System.out.println("currentDay :"+currentDay);
		
		long diff = currentDay.getTime() - startDay.getTime();
		long diffDays = diff / (24 * 60 * 60 * 1000);
		System.out.println("diffDays :"+diffDays);
		int rentDay = (int)diffDays;
		System.out.println("rentDay Ȯ�� :"+rentDay);
		
		//��������� ���� ���� ������
		int price = rent.getMemberlevelPayment();
		
		int totalPay = price*rentDay;
		System.out.println("�뿩 �ѱݾ� :"+totalPay);
		rent.setTotalPayment(totalPay);
		//�����ޱ� ������
		int prePayment = rent.getRentalPrePayment();
		//�����ݾ�
		int willPay = totalPay-prePayment;
		rent.setWillRiceivePay(willPay);
		
		/*public static long diffOfDate(String begin, String end) throws Exception
		  {
		    SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
		 
		    Date beginDate = formatter.parse(begin);
		    Date endDate = formatter.parse(end);
		 
		    long diff = endDate.getTime() - beginDate.getTime();
		    long diffDays = diff / (24 * 60 * 60 * 1000);
		 
		    return diffDays;*/
		
		
		
		return rent;
	}
	
	
	//���� ���� Ȯ��(1=�뿩����) �� �� �������� �Է�+�������� ����
	public int bookStateSelectAndRental(RentalDto rental){
		//��Ż�ڵ带 ��������� ���� ��,��,�� �� ������
		/*Calendar cal = Calendar.getInstance();
		String nowDay = "";
		nowDay += cal.get(cal.YEAR);
		System.out.println("nowDayȮ�� : "+nowDay);
		nowDay += cal.get(cal.MONTH)+1;
		System.out.println("nowDay Ȯ�� : "+nowDay);
		nowDay += cal.get(cal.DAY_OF_MONTH);
		System.out.println("nowDay Ȯ�� :"+nowDay);*/
		
		logger.debug("service�� ����");
		//���������ڵ� ��ȸ
		int x = rentalDao.bookStateSelect(rental);
		System.out.println("���¹�ȣ Ȯ�� :"+x);
		
		//�������°� �뿩������ �ƴϸ�
		if(x!=1){
			System.out.println("�뿩�Ұ�");
			//2�� �������� �뿩�Ұ��� ���� �뿩�Ұ�
			return 0;
		}else{
			//�������°� �뿩�����϶�
			//�����뿩���� �Է� (���̵� ��ġ���� Ȯ���ϴ� ��ȿ���˻� ������)
				rentalDao.rentalInsert(rental);
				//�������� �뿩������ ������Ʈ
				rentalDao.bookStateUpdate(rental);
			}
			return 0;
		}
	}

