package pojo;

import org.springframework.web.multipart.MultipartFile;

//上传pojo类
public class UploadPojo {
	
	private MultipartFile file;
	private String desc;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public UploadPojo() {
		super();
	}

	public UploadPojo(MultipartFile file,String desc) {
		super();
		
		this.file=file;
		this.desc=desc;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Override
	public String toString() {
		return "Upload [filename=" + file + ", error=" + desc + "]";
	}
	
}
