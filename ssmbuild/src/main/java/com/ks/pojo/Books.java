package com.ks.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Books {
    // 与数据库字段名一致
    private int bookID;
    private String bookName;
    private int bookCounts;
    private String detail;
}
