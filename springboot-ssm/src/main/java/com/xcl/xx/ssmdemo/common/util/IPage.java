package com.xcl.xx.ssmdemo.common.util;/**
 * @author xuchunlong
 * @create 2022-09-16-18:08
 */

import java.util.ArrayList;
import java.util.List;

/**
 * @author: gfk
 * @create: 2022/9/16
 * @Description:
 * @FileName: PageBean
 * @History:
 * @自定义内容：
 */
public class IPage<T> {

    private int pageNo;
    private int pageSize ;
    private int totalCount; //记录总数
    private int totalPages; //页数,只读
    private List<T> pageList;


    public int getPageNo() {
        return pageNo;
    }
    // 当前页数不能小于1，也不能大于总页数(有参构造生成对象，用内部)
    public void setPageNo(int pageNum){
        if(pageNo<1) {
            this.pageNo = 1;
        } else if(pageNo > totalPages){
            this.pageNo = totalPages;
        } else {
            this.pageNo = pageNum;
        }
    }
    // 当前页数不能小于1，也不能大于总页数
    public void setPageNum(int pageNum){
        if(pageNum<1) {
            this.pageNo = 1;
        } else if(pageNum > totalPages){
            this.pageNo = totalPages;
        } else {
            this.pageNo = pageNum;
        }
    }
    public int getPageSize() {
        return pageSize;
    }
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
    // 记录的总数决定了页面的总数
    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
        this.totalPages = (this.totalCount%this.pageSize==0)?this.totalCount/this.pageSize:this.totalCount/this.pageSize+1;
    }
    public int getTotalCount() {
        return totalCount;
    }
    // 只读
    public int getTotalPages() {
        return totalPages;
    }
    public List<T> getPageList() {
        return pageList;
    }
    public void setPageList(List<T> pageList) {
        this.pageList = pageList;
    }
    public IPage(int pageNo, int pageSize, int totalCount, int totalPages,
                    List<T> pageList) {
        super();
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.totalCount = totalCount;
        this.totalPages = totalPages;
        this.pageList = pageList;
    }
    public IPage() {
        super();
     }
}