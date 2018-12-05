package org.core.util;

public interface Constants {

	public enum STATUS{
		ACITVE("A"), DELETED("D"), INACTIVE("IA");
		
		private String status;
		STATUS(String status){
			this.status = status;
		}
		public String getValue(){
			return this.status;
		}
	}
	
	public enum DATEFORMAT{
		MM_DD_YYYY("dd/MMM/yyyy hh:mm:ss a");
		
		private String value;
		DATEFORMAT(String value){
			this.value= value;
		}
		public String getValue(){
			return this.value;
		}
	}
	
}
