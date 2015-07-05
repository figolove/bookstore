package feng.domain;

import java.util.List;

public class Page {
	private int totalrecord; //总纪录数
	private int pagesize = 3;    //每页显示多少个
	private int totalpage;    //总页数
	
	private int pagenum;    //每几页
	private int startindex;  //根据页号，算出该页在数据库中的起始位置
	
	private int foreachbegin;  //根据页号，算出在页面中foreach标签的开始数
	private int foreachend;    //根据页号，算出在页面中foreach标签的结束数
	
	private List list;    //封装页面数据
	
	
	public Page(int totalrecord,int pagenum){
		this.totalrecord = totalrecord;
		this.pagenum = pagenum;
		
		//算出总页数
		if(this.totalrecord%pagesize==0){
			this.totalpage = this.totalrecord/this.pagesize;
		}else{
			this.totalpage = this.totalrecord/this.pagesize + 1;
		}
		
		
		//根据页号，算出该页的数据应该从数据库哪个位置开始取
		this.startindex = (this.pagenum-1)*this.pagesize;
		
		//根据页号，算出foreachbegin和foreachend
		if(this.totalpage<=10){
			this.foreachbegin = 1;
			this.foreachend = this.totalpage;
		}else{
			this.foreachbegin = this.pagenum-4;
			this.foreachend = this.pagenum+5;
			
			if(foreachbegin<1){
				this.foreachbegin = 1;
				this.foreachend = 10;
			}else if(this.foreachend>this.totalpage){
				this.foreachend = this.totalpage;
				this.foreachbegin = pagenum-10+1;
			}
		}
	}


	public int getTotalrecord() {
		return totalrecord;
	}


	public void setTotalrecord(int totalrecord) {
		this.totalrecord = totalrecord;
	}


	public int getPagesize() {
		return pagesize;
	}


	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}


	public int getTotalpage() {
		return totalpage;
	}


	public void setTotalpage(int totalpage) {
		this.totalpage = totalpage;
	}


	public int getPagenum() {
		return pagenum;
	}


	public void setPagenum(int pagenum) {
		this.pagenum = pagenum;
	}


	public int getStartindex() {
		return startindex;
	}


	public void setStartindex(int startindex) {
		this.startindex = startindex;
	}


	public int getForeachbegin() {
		return foreachbegin;
	}


	public void setForeachbegin(int foreachbegin) {
		this.foreachbegin = foreachbegin;
	}


	public int getForeachend() {
		return foreachend;
	}


	public void setForeachend(int foreachend) {
		this.foreachend = foreachend;
	}


	public List getList() {
		return list;
	}


	public void setList(List list) {
		this.list = list;
	}
}
