package CommonFunlibrary;

import org.testng.annotations.Test;

import utilities.Excelfileutil;

public class NewTest {
  @Test
  public void f() throws Throwable {
	  ERP_Function erp=new ERP_Function();
	  Excelfileutil exl=new Excelfileutil();
		int rowcount=exl.rowcount("Supplier");
		for(int i=1;i<=rowcount;i++){
			String sname=exl.getdata("Supplier", i, 0);
			String address=exl.getdata("Supplier", i, 1);
			 String city=exl.getdata("Supplier", i, 2);
			 String country=exl.getdata("Supplier", i, 3);
			 String cperson=exl.getdata("Supplier", i, 4);
			 String pnumber=exl.getdata("Supplier", i, 5);
			 String mail=exl.getdata("Supplier", i, 6);
			 String mnumber=exl.getdata("Supplier", i, 7);
			 String note=exl.getdata("Supplier", i, 8);
			 erp.launchApp("http://webapp.qedge.com/");
			 erp.login("admin", "master");
				String Results= erp.Suppiler(sname, address, city, country, cperson, pnumber, mail, mnumber, note);
			      exl.setdata("supplier", i, 9, Results);
				 
				 erp.logout();
				 
  }
}
  }
