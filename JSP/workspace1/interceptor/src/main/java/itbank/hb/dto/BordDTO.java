package itbank.hb.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class BordDTO {
	private int hobby_idx;
	private String name , title , content , gender, hobby;
	private String img_file_name;
	private int rn;
	private MultipartFile upload_f;
	private int cnt;
}