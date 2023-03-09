package com.ryytn.start.common;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>分页result</p>
 *
 * @author yinxin
 * @since 2022/05/22
 */
@Data
public class PaginationResult<T> implements Serializable {
    /**
     * 当前第几页
     */
    private Integer pageNO;
    /**
     * 每页记录数
     */
    private Integer pageSize;
    /**
     * 总共页数
     */
    private Integer pageCount;
    /**
     * 总共记录数
     */
    private Integer total;
    /**
     * 数据
     */
    private List<T> dataList;

    public static PaginationResult getEmpty() {
        return new PaginationResult<>(0, new ArrayList<>());
    }

    public static <T> PaginationResult<T> buildEmpty(Integer pageNO, Integer pageSize) {
        PaginationResult<T> ept = PaginationResult.getEmpty();
        ept.setPageNO(pageNO);
        ept.setPageSize(pageSize);
        return ept;
    }

    public PaginationResult() {
    }

    public PaginationResult(Integer total, List<T> dataList) {
        this.total = total;
        this.dataList = dataList;
    }
}
