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
	//반납부분
	//도서코드 입력받으면 도서코드로 대여정보 조회
	//조회된 대여정보에서 memberId를 가지고 해당멤버의 level에 해당하는 payment가지고옴
	// 
	
	//반납 ReturnDto타입 객체로 값 넘겨받음
	public int bookReturn(ReturnDto bookReturn){
		//해야할일
		//대여테이블의 대여상태코드 1->2로 업데이트, 대여테이블의 반납일 입력해줌
		//대여테이블의 payment(총요금)에 totalPayment값 넣어주기
		rentalDao.rentalUpdate(bookReturn);
		//book테이블의 상태코드 1번 대여가능으로 업데이트, totalDay에 대여일 기존+업데이트,
		//totalCount에 +1해줌
		//book테이블의 firstDay,totalDay, totalCount 조회
		BookDto book =rentalDao.bookTotalSelect(bookReturn);
		int bookTotalCount = book.getBookTotalcount();
		int bookTotalDay = book.getBookTotalday();
		System.out.println("totalDay : "+bookTotalDay+" totalCount : "+bookTotalCount);
		bookTotalCount += 1;
		int rentDay = bookReturn.getRentDay();
		System.out.println("대여일확인 : "+rentDay);
		bookTotalDay += rentDay;
		String bookCode = bookReturn.getBookCode();
		System.out.println("북코드 확인 : "+bookCode);
		
		String first = book.getBookFirstday();
		if(first==null){
			rentalDao.bookFirstDayUpdate(bookReturn);
		}
		
		//bookDto타입 객체에 코드,토탈값 담음( 업데이트하기위함)
		BookDto bookUpdate = new BookDto();
		bookUpdate.setBookCode(bookCode);
		bookUpdate.setBookTotalcount(bookTotalCount);
		bookUpdate.setBookTotalday(bookTotalDay);
		
		rentalDao.bookTotalUpdate(bookUpdate);
		
		
		return 0;
	}
	
	
	//도서코드로 대여정보 조회
	public ReturnDto rentalInfoSelect(String bookCode){
		ReturnDto rent = rentalDao.rentalInfoSelect(bookCode);
		//ReturnDto 타입으로 값 받아옴
		System.out.println(rent.toString());
		
		//대여일 String으로 가져와 Date타입으로 변환하여 현재날짜-대여일 계산
		String rentalStart = rent.getRentalStart();
		System.out.println("대여시작일 가져옴 : "+rentalStart.toString());
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
		System.out.println("rentDay 확인 :"+rentDay);
		rent.setRentDay(rentDay);
		//멤버레벨에 따른 가격 가져옴
		int price = rent.getMemberlevelPayment();
		
		int totalPay = price*rentDay;
		System.out.println("대여 총금액 :"+totalPay);
		rent.setTotalPayment(totalPay);
		//선지급금 가져옴
		int prePayment = rent.getRentalPrePayment();
		//받을금액
		int willPay = totalPay-prePayment;
		rent.setWillRiceivePay(willPay);
		return rent;
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

