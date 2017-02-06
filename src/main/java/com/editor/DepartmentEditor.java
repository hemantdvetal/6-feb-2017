package com.editor;

import java.beans.PropertyEditorSupport;

import com.model.Department;

public class DepartmentEditor extends PropertyEditorSupport {

	
	public void setAsText(String deptid) {
		System.out.println("222222222222222 DepartmentEditor::" + deptid);
		Department d = null;
		if (Integer.parseInt(deptid) > 0) {
			d = new Department();
			d.setDid(Integer.parseInt(deptid));
		}
		this.setValue(d);
	}
	
	
	public String getAsText() {
		System.out.println("In editor..........");
		return super.getAsText();
	}
}
