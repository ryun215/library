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
	
	
	//도서코드로 대여정보 조회
	public RentalDao rentalInfoSelect(){
		return null;
	}
	
	
	//도서 상태 확인(1=대여가능) 한 후 도서정보 입력+도서상태 변경
	public int bookStateSelectAndRental(RentalDto rental){
		//렌탈코드를 만들기위해 현재 연,월,일 을 가져옴
		/*Calendar cal = Calendar.getInstance();
		String nowDay = "";
		nowDay += cal.get(cal.YEAR);
		System.out.println("nowDay확인 : "+nowDay);
		nowDay += cal.get(cal.MONTH)+1;
		System.out.println("nowDay 확인 : "+nowDay);
		nowDay += cal.get(cal.DAY_OF_MONTH);
		System.out.println("nowDay 확인 :"+nowDay);*/
		
		logger.debug("service단 들어옴");
		//도서상태코드 조회
		int x = rentalDao.bookStateSelect(rental);
		System.out.println("상태번호 확인 :"+x);
		
		//도서상태가 대여가능이 아니면
		if(x!=1){
			System.out.println("대여불가");
			//2는 도서상태 대여불가로 인해 대여불가
			return 0;
		}else{
			//도서상태가 대여가능일때
			//도서대여정보 입력 (아이디 일치여부 확인하는 유효성검사 안했음)
				rentalDao.rentalInsert(rental);
				//도서상태 대여중으로 업데이트
				rentalDao.bookStateUpdate(rental);
			}
			return 0;
		}
	}

