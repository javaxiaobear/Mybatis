package com.yan.mapper;


import com.yan.pojo.Blog;

import java.util.List;
import java.util.Map;


public interface BlogMapper {

    int addblog(Blog blog);

    List<Blog> queryBlogIF(Map map);
}
