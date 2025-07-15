import request from '@/utils/request' // 假设您有封装好的request工具

export const getCoursesPage = (params) => {
  return request({
    url: `/course/list`,  // 保持与服务端一致
    method: "get",
    params
  })
}
export const getCourseDetailApi = (id) =>
  request({
    url: `/course/baseInfo/${id}`,
    method: "get",
  });
// export function getCourseListAPI(params) {
//   return request({
//     url: '/course/list',
//     method: 'get',
//     params,
//   });
// }
