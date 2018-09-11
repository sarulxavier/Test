package com.vayana.boot.infra.web.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import com.vayana.boot.common.error.SecurityBreachException;

@Component
@ConfigurationProperties(prefix = "app", ignoreUnknownFields = true)
public class WebAppProperties {

	private String apiURL;
	private String startURL;
	private String defaultLocale = "en_US";
	private String resourceLocations;
	private String firstTimeLoginUrl;
	private String apiContextPath = null;
	private Map<String,String> locales =  new HashMap<>();
	private String cibFolderPath;
	private String clientName;

	private final Security security = new Security();

	
	public String validateAndRedirect(String redirectKey) {
		String whitelistUrl = this.security.getWhitelistUrls().get(redirectKey);
		if (whitelistUrl != null) {
			return "redirect:"+ whitelistUrl;
		}else {
			throw new SecurityBreachException("UNVALIDATED_REDIRECTS");
		}
	}
	
	
	public Security getSecurity() {
		return security;
	}

	public static class Security {
		private Integer sessionTimeout = 10;
		private Integer maximumSessions = 1;
		private Boolean maxSessionsPreventsLogin = false;
		private String allowedTags;
		private Boolean allowLoginInvalidUser = true;
		private Integer maxBruteForceAttempts = 10;
		private Integer bruteForceLockOutInHours = 10;
		private Integer maxCaptchaAttempts = 5;
		private Integer maxOTPAttempts = 5;
		// due to incorrect max OTP attempts
		private Integer txnLockOutInHours = 10;
		private Long secimgDefault = 70200L;
		private Boolean virtualKeyboardEnabled = false;
		private Map<String, String> whitelistUrls = new HashMap<String, String>();
		
		public Map<String, String> getWhitelistUrls() {
			return whitelistUrls;
		}

		public void setWhitelistUrls(Map<String, String> whitelistUrls) {
			this.whitelistUrls = whitelistUrls;
		}

		
		public Boolean getVirtualKeyboardEnabled() {
			return virtualKeyboardEnabled;
		}

		public void setVirtualKeyboardEnabled(Boolean virtualKeyboardEnabled) {
			this.virtualKeyboardEnabled = virtualKeyboardEnabled;
		}

		public Integer getTxnLockOutInHours() {
			return txnLockOutInHours;
		}

		public void setTxnLockOutInHours(Integer txnLockOutInHours) {
			this.txnLockOutInHours = txnLockOutInHours;
		}

		public Integer getBruteForceLockOutInHours() {
			return bruteForceLockOutInHours;
		}

		public void setBruteForceLockOutInHours(Integer bruteForceLockOutInHours) {
			this.bruteForceLockOutInHours = bruteForceLockOutInHours;
		}

		public Long getSecimgDefault() {
			return secimgDefault;
		}

		public void setSecimgDefault(Long secimgDefault) {
			this.secimgDefault = secimgDefault;
		}

		public Integer getMaxBruteForceAttempts() {
			return maxBruteForceAttempts;
		}

		public void setMaxBruteForceAttempts(Integer maxBruteForceAttempts) {
			this.maxBruteForceAttempts = maxBruteForceAttempts;
		}

		public Integer getMaxCaptchaAttempts() {
			return maxCaptchaAttempts;
		}

		public void setMaxCaptchaAttempts(Integer maxCaptchaAttempts) {
			this.maxCaptchaAttempts = maxCaptchaAttempts;
		}

		public Integer getMaxOTPAttempts() {
			return maxOTPAttempts;
		}

		public void setMaxOTPAttempts(Integer maxOTPAttempts) {
			this.maxOTPAttempts = maxOTPAttempts;
		}

		public Integer getSessionTimeout() {
			return sessionTimeout;
		}

		public void setSessionTimeout(Integer sessionTimeout) {
			this.sessionTimeout = sessionTimeout;
		}

		public Integer getMaximumSessions() {
			return maximumSessions;
		}

		public void setMaximumSessions(Integer maximumSessions) {
			this.maximumSessions = maximumSessions;
		}

		public Boolean getMaxSessionsPreventsLogin() {
			return maxSessionsPreventsLogin;
		}

		public void setMaxSessionsPreventsLogin(Boolean maxSessionsPreventsLogin) {
			this.maxSessionsPreventsLogin = maxSessionsPreventsLogin;
		}

		public String getAllowedTags() {
			return allowedTags;
		}

		public void setAllowedTags(String allowedTags) {
			this.allowedTags = allowedTags;
		}

		public Boolean getAllowLoginInvalidUser() {
			return allowLoginInvalidUser;
		}

		public void setAllowLoginInvalidUser(Boolean allowLoginInvalidUser) {
			this.allowLoginInvalidUser = allowLoginInvalidUser;
		}

	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getCibImageFolderPath() {
		return cibFolderPath + "/resources/images";
	}

	public String getCibFolderPath() {
		return cibFolderPath;
	}

	public String getCibTempFolderPath() {
		return cibFolderPath + "/temp/";
	}

	public String getCibDownloadFolderPath() {
		return cibFolderPath + "/temp/downloads";
	}

	public String getCibUploadFolderPath() {
		return getCibImageFolderPath() + "/upload";
	}

	public String getCibReportFolderPath() {
		return cibFolderPath + "/temp/reports";
	}

	public void setCibFolderPath(String cibFolderPath) {
		this.cibFolderPath = cibFolderPath;
	}

	public String getApiURL(String url) {
		return apiURL + url;
	}

	public void setApiURL(String apiURL) {
		this.apiURL = apiURL;
	}

	public String getStartURL() {
		return startURL;
	}

	public void setStartURL(String startURL) {
		this.startURL = startURL;
	}

	public String getDefaultLocale() {
		return defaultLocale;
	}

	public void setDefaultLocale(String defaultLocale) {
		this.defaultLocale = defaultLocale;
	}

	public String getResourceLocations() {
		return resourceLocations;
	}

	public void setResourceLocations(String resourceLocations) {
		this.resourceLocations = resourceLocations;
	}

	public String getFirstTimeLoginUrl() {
		return firstTimeLoginUrl;
	}

	public void setFirstTimeLoginUrl(String firstTimeLoginUrl) {
		this.firstTimeLoginUrl = firstTimeLoginUrl;
	}

	public String getApiContextPath() {
		return apiContextPath;
	}

	public void setApiContextPath(String apiContextPath) {
		this.apiContextPath = apiContextPath;
	}

	public String getApiURL() {
		return apiURL;
	}

	public Map<String, String> getLocales() {
		return locales;
	}

	public void setLocales(Map<String, String> locales) {
		this.locales = locales;
	}

}
