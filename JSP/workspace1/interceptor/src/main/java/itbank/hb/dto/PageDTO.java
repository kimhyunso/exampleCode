package itbank.hb.dto;

import lombok.Data;

@Data
public class PageDTO {
	private int start ,end;
	private int pagestart,pageend;
	private int pnum;
	private int temp;
	private String skey , sval;
	private int total;
	private String sskey;
}