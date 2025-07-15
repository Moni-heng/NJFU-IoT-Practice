import request from "@/utils/request.js";

// 获取课程分类列表
export const getPcodeList = (params) =>
  request({
    url: `/pCode/list`,
    method: "post",
    params,
  });


export const getCategorysAll = (params) => {
  return request({
    url: '/category/all',
    method: 'get',
  });
};

// ✅ 新增：获取所有标签项
export const getTagItemList = () => {
  return request({
    url: '/tagItem/list',
    method: 'get',
  });
};
export const getCoursesPage = (params) => {
  return request({
    url: '/course/list',
    method: 'get',
    params,
  });
}
