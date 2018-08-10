package pojo;

//上传pojo类
public class Upload {
	
	private String filename;
	private String error;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public Upload() {
		super();
	}

	public Upload(String filename,String error) {
		super();
		
		this.filename=filename;
		this.error=error;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}
	
	

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	@Override
	public String toString() {
		return "Upload [filename=" + filename + ", error=" + error + "]";
	}

	
	
	
}
