package com.ksmart.library.rental.service;

import java.awt.print.Printable;
import java.util.Calendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ksmart.library.dto.RentalDto;

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
	public RentalDao rentalInfoSelect(RentalDto rental){
		RentalDto rent = rentalDao.rentalInfoSelect(rental);
		System.out.println(rent.toString());
		return null;
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

