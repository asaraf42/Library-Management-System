package com.app.dto;

public class BookDTO {

		private int bid;
		private String bname;
		private String bauthor;
		private double price;
		private int bquantity;
		private int pages;
		
		public BookDTO() {}
		
		public BookDTO(int bid, String bname, String bauthor, double price, int bquantity, int pages) 
		{
			this.bid = bid;
			this.bname = bname;
			this.bauthor = bauthor;
			this.price = price;
			this.bquantity = bquantity;
			this.pages = pages;
		}

		public int getBid() {
			return bid;
		}
		public void setBid(int bid) {
			this.bid = bid;
		}
		public String getBname() {
			return bname;
		}
		public void setBname(String bname) {
			this.bname = bname;
		}
		public String getBauthor() {
			return bauthor;
		}
		public void setBauthor(String bauthor) {
			this.bauthor = bauthor;
		}
		public double getPrice() {
			return price;
		}
		public void setPrice(double price) {
			this.price = price;
		}
		public int getBquantity() {
			return bquantity;
		}
		public void setBquantity(int bquantity) {
			this.bquantity = bquantity;
		}
		public int getPages() {
			return pages;
		}
		public void setPages(int pages) {
			this.pages = pages;
		}
	
	

}
