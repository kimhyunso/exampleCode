package org.zerock.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SampleVO {

	
	private Integer mno;
	private String firstName;
	private String lastName;
	
	/*AllArgsConstructor : �⺻�����ڿ� ���� �ڵ����� ä����
	 * public SampleVO(Integer mno, String firstName, String lastName){
	 * 		this.mno = mno;
	 * 		this.firstName = fistName;
	 * 		this.lastName = lastName;
	 * }
	 * */
	
	/*NoArusContructor : �⺻������ �ڵ����� �������
	 * public SampleVO(){
	 * }
	 * */
	
	/*RequiredArgsConstructor : final ����, Notnull ǥ�ð� �� ����ó�� �ʼ����� ������ �����ϴ� �����ڸ� ������ش�.
	 * public SampleVO(Integer mno){
	 * 		this.mno = mno;
	 * }
	 * */
	
	
}
