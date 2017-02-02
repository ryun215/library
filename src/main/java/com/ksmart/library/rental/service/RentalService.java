package com.ksmart.library.rental.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ksmart.library.dto.BookDto;
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
	
	//�ݳ� ReturnDtoŸ�� ��ü�� �� �Ѱܹ���
	public int bookReturn(ReturnDto bookReturn){
		//�ؾ�����
		//�뿩���̺��� �뿩�����ڵ� 1->2�� ������Ʈ, �뿩���̺��� �ݳ��� �Է�����
		//�뿩���̺��� payment(�ѿ��)�� totalPayment�� �־��ֱ�
		rentalDao.rentalUpdate(bookReturn);
		//book���̺��� �����ڵ� 1�� �뿩�������� ������Ʈ, totalDay�� �뿩�� ����+������Ʈ,
		//totalCount�� +1����
		//book���̺��� firstDay,totalDay, totalCount ��ȸ
		BookDto book =rentalDao.bookTotalSelect(bookReturn);
		int bookTotalCount = book.getBookTotalcount();
		int bookTotalDay = book.getBookTotalday();
		System.out.println("totalDay : "+bookTotalDay+" totalCount : "+bookTotalCount);
		bookTotalCount += 1;
		int rentDay = bookReturn.getRentDay();
		System.out.println("�뿩��Ȯ�� : "+rentDay);
		bookTotalDay += rentDay;
		String bookCode = bookReturn.getBookCode();
		System.out.println("���ڵ� Ȯ�� : "+bookCode);
		
		String first = book.getBookFirstday();
		if(first==null){
			rentalDao.bookFirstDayUpdate(bookReturn);
		}
		
		//bookDtoŸ�� ��ü�� �ڵ�,��Ż�� ����( ������Ʈ�ϱ�����)
		BookDto bookUpdate = new BookDto();
		bookUpdate.setBookCode(bookCode);
		bookUpdate.setBookTotalcount(bookTotalCount);
		bookUpdate.setBookTotalday(bookTotalDay);
		
		rentalDao.bookTotalUpdate(bookUpdate);
		
		
		return 0;
	}
	
	
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
		rent.setRentDay(rentDay);
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

