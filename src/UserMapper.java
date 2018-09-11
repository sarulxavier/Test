package com.vayana.testharness.api.model;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.vayana.boot.common.vo.UserFAPVO;
import com.vayana.boot.common.vo.UserProfileVO;

/**
 * @author kamal
 * 19-Mar-2017
 */

@Mapper
public interface UserMapper {
    UserProfileVO getAdminUserProfile(@Param("userLogin") String userLogin, @Param("groupId") Long groupId);
    UserProfileVO getCorporateUserProfile(@Param("userLogin") String userLogin, @Param("groupId") Long groupId);
    UserProfileVO getUserProfileById(@Param("ulpId") Long userLoginProfileId);
    UserProfileVO getPreLoginDetails(@Param("userLogin") String userLogin, @Param("groupCode") String groupCode);
    List<UserFAPVO> getAdminUserFapByLoginId(@Param("ulpId") Long userLoginProfileId);
    List<UserFAPVO> getSuperUserFap();
    Map<String,Object> getBrandingInfo(@Param("groupId") Long groupId);
    List<UserFAPVO> getCustomerUserFapByLoginId(@Param("ulpId") Long userLoginProfileId);
	String getMobileNumberByUlpId(@Param("ulpId") Long userLoginProfileId);
	String getEmailAddressByUlpId(@Param("ulpId") Long userLoginProfileId);
	List<String> getFAPBusinessFunctionByULP(@Param("ulpId") Long userLoginProfileId,@Param("privilege") String privilege);
	List<Long> getUserAccessRightByULPAndFunction(@Param("ulpId") Long userLoginProfileId,@Param("businessFunctionId") Long businessFunctionId);
	Long getRoleAccessRightDetailByULPAndFunction(@Param("ulpId") Long userLoginProfileId,@Param("businessFunctionId") Long businessFunctionId,
			@Param("accessRightId") Long accessRightId);
	
	void expireUserTask(@Param("ulpId")Long ulpId,@Param("code")String code,@Param("eventSource")Long eventSource);
	Long getPendingCountByUser(@Param("ulpId")Long ulpId);
	List<String> getRemovedPrivilegeBusinessFunctionByULP(@Param("ulpId")Long ulp,@Param("privilege")String privilege);
}