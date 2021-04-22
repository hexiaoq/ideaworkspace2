<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/6/24
  Time: 11:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="page_nav">
    <c:if test="${requestScope.page.pageNo>1}">
        <a href="http://localhost:8080/bookcity3/${requestScope.page.url}">首页</a>
        <a href="http://localhost:8080/bookcity3/${requestScope.page.url}?pageNo=${requestScope.page.pageNo-1}">上一页</a>
        <a href="http://localhost:8080/bookcity3/${requestScope.page.url}?pageNo=${requestScope.page.pageNo-1}">${requestScope.page.pageNo-1}</a>
    </c:if>

    <%--当页面为末页时,不显示下一页,末页和越界页--%>
    【${requestScope.page.pageNo}】
    <c:if test="${requestScope.page.pageNo<requestScope.page.pagetotal}">
        <a href="http://localhost:8080/bookcity3/${requestScope.page.url}?pageNo=${requestScope.page.pageNo+1}">${requestScope.page.pageNo+1}</a>
        <a href="http://localhost:8080/bookcity3/${requestScope.page.url}?pageNo=${requestScope.page.pageNo+1}">下一页</a>
        <a href="http://localhost:8080/bookcity3/${requestScope.page.url}?pageNo=${requestScope.page.pagetotal}">末页</a>

    </c:if>

    共${requestScope.page.pagetotal}页，${requestScope.page.pagetalcount}条记录 到第<input value="${requestScope.page.pageNo}" name="pn" id="pn_input"/>页
    <input type="button" id="searchPageBtn" value="确定">
    <script type="text/javascript">
        $(function () { // 跳 到 指 定 的 页 码
            $("#searchPageBtn").click(function () {
                var pageNo = $("#pn_input").val();

                // javaScript 语 言 中 提 供 了 一 个 location 地 址 栏 对 象
                // 它 有 一 个 属 性 叫 href. 它 可 以 获 取 浏 览 器 地 址 栏 中 的 地 址
                // href 属 性 可 读 ， 可 写

                location.href = "http://localhost:8080/bookcity3/${requestScope.page.url}?pageNo="+pageNo;

            }); });
    </script>

</div>
