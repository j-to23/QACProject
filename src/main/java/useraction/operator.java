package useraction;

import util.utils;

public class operator {
	public operator(){
		
	}
	
	String getinput(){
		return utils.getinput();
	}
	public String operatorselect() {
		String operation = "";
		
		System.out.println("Create(1), Read(2), Update(3) or Delete(4) records?");
		boolean operationcheck = true;
		do {
			operation = getinput().toString().toLowerCase();
			if (operation.equals("1") || operation.equals("2") || operation.equals("3") || operation.equals("4")
					|| operation.equals("create") || operation.equals("read") || operation.equals("update")
					|| operation.equals("delete")) {
				operationcheck = false;
			} else {
				System.out.println("Please type one of the given options or its associated number.");
			}
		} while (operationcheck);
		
		return operation;
	}
}
