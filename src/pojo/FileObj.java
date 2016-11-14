package pojo;

public class FileObj {
	int num;
	String ctg;
	String title;
	String filename;
	String fileuuid;
	long filesize;
	String uploader;
	int count;
	public FileObj(String ctg, String title, String filename, String fileuuid, long filesize, String uploader) {
		this(0,ctg,title,filename,fileuuid,filesize,uploader,0);
	}
	public FileObj() {
		this(0,null,null,null,null,0,null,0);
	}
	public FileObj(int num, String ctg, String title, String filename, String fileuuid, long filesize, String uploader,
			int count) {
		this.num = num;
		this.ctg = ctg;
		this.title = title;
		this.filename = filename;
		this.fileuuid = fileuuid;
		this.filesize = filesize;
		this.uploader = uploader;
		this.count = count;
	}

	@Override
	public String toString() {
		return "FileObj [num=" + num + ", ctg=" + ctg + ", title=" + title + ", filename=" + filename + ", fileuuid="
				+ fileuuid + ", filesize=" + filesize + ", uploader=" + uploader + ", count=" + count + "]";
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getCtg() {
		return ctg;
	}
	public void setCtg(String ctg) {
		this.ctg = ctg;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getFileuuid() {
		return fileuuid;
	}
	public void setFileuuid(String fileuuid) {
		this.fileuuid = fileuuid;
	}
	public long getFilesize() {
		return filesize;
	}
	public void setFilesize(long filesize) {
		this.filesize = filesize;
	}
	public String getUploader() {
		return uploader;
	}
	public void setUploader(String uploader) {
		this.uploader = uploader;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
}
