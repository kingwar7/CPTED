package com.cpted.dao;

import java.util.ArrayList;

import com.cpted.beans.MemberCrimeWatch;
import com.cpted.beans.MemberGeneralUser;
import com.cpted.beans.MemberPolice;

public interface MemberAndCurrentLocationDao {
	// 방범대를 선택하고 전송을 눌렀을 때 보내 보내지는 사람들 리스트
		public ArrayList<MemberCrimeWatch> GetNearCrimeWatchMembers(
				String longtitude, String latitude) throws Exception;
		
		// 일반사용자를 선택하고 전송을 눌렀을 때 보내 보내지는 사람들 리스트
		public ArrayList<MemberGeneralUser> GetNearGeneralUserMembers(
				String longtitude, String latitude) throws Exception ;
		
		// 경찰및 공무원 을 선택하고 전송을 눌렀을 때 보내 보내지는 사람들 리스트
		public ArrayList<MemberPolice> GetNearPoliceMembers(String longtitude,
				String latitude) throws Exception ;
		
		// 방범대를 선택한 상태의 화면에 보이는 방범대원 리스트
		public ArrayList<MemberCrimeWatch> GetCrimeWathMembersInView(String top, String left,
				String right, String bottom) throws Exception;
		
		
		// 일반사용자를 선택한 상태의 화면에 보이는 방범대원 리스트
		public ArrayList<MemberGeneralUser> GetGeneralUserMembersInView(String top, String left,
				String right, String bottom) throws Exception;
		
		// 방범대를 선택한 상태의 화면에 보이는 방범대원 리스트
		public ArrayList<MemberPolice> GetPoliceMembersInView(String top, String left,
				String right, String bottom) throws Exception;
		
		
		
		
}
