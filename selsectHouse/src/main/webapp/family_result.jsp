<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head id="Head1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=8">
<title>销售信息公示平台</title>
<link href="view/css/main.css" rel="stylesheet">
<script src="view/js/jquery.min.js"></script>
<script src="view/js/layer.js"></script>
<link rel="stylesheet" href="view/css/layer.css" id="layuicss-layer">
<script src="view/js/main.js"></script>
</head>
<body>
	<form method="post" action="http://zfyxdj.xa.gov.cn/zfrgdjpt/xmgs.aspx"
		onkeypress="javascript:return WebForm_FireDefaultButton(event, &#39;btnSubmit&#39;)"
		id="form1">
		<div class="aspNetHidden">
			<input type="hidden" name="__EVENTTARGET" id="__EVENTTARGET" value="">
			<input type="hidden" name="__EVENTARGUMENT" id="__EVENTARGUMENT"
				value=""> <input type="hidden" name="__VIEWSTATE"
				id="__VIEWSTATE"
				value="rLaTylGP9uJooVBhpqXhG4aIfXP+rYtUsMT+avGGGI8GGBY/n5tM3eOESKviTjtCOWwu1nntBL8W4WuD7QvXLg7RWHApNEoeLgg+s6u3S0k=">
		</div>

		<script type="text/javascript">
//<![CDATA[
var theForm = document.forms['form1'];
if (!theForm) {
    theForm = document.form1;
}
function __doPostBack(eventTarget, eventArgument) {
    if (!theForm.onsubmit || (theForm.onsubmit() != false)) {
        theForm.__EVENTTARGET.value = eventTarget;
        theForm.__EVENTARGUMENT.value = eventArgument;
        theForm.submit();
    }
}
//]]>
</script>


		<script src="./WebResource.axd" type="text/javascript"></script>


		<script src="./WebResource(1).axd" type="text/javascript"></script>
		<div class="aspNetHidden">

			<input type="hidden" name="__VIEWSTATEGENERATOR"
				id="__VIEWSTATEGENERATOR" value="4E920C22"> <input
				type="hidden" name="__EVENTVALIDATION" id="__EVENTVALIDATION"
				value="zaeFN5M+Yn1/6QCyAUQIlx/HnT63/RP/Eg+13YQP4zcE1y6wmMXMqFxOwgVKcWKLF/I2lblijC4a/R7FfAM9hGNqkbECf1bzFpaqLbR9S90QnqIkhcjHw7LZXknhh365G52nIPcie34ayYUduCOGvg==">
		</div>


		<link href="sale_show/css/header.css" rel="stylesheet">
		<div id="Wuc_header_header00" class="header header00 top00">
			<img src="sale_show/img/topimg07.jpg">
		</div>



		<input type="hidden" name="hidDayDjsj" id="hidDayDjsj" value="8-18">
		<div class="bgwhite caq_tbtsdiv">

			<div align="center">
				<span style="font-size: 20px; color: red;">声明：
					公示结果可能因群众提出异议，企业操作有误等原因有所调整，单仅限于已公示意向登记人的信息调整，不再新增登记意向人。</span>
			</div>
		</div>
		<div class="content">
			<div class="bgwhite  mag_tb">
				<div class="mag_b10 prel pad_10 pad_t25">
					<div class="tc size22 pad_lr20">销售信息功能模块</div>
				</div>
				<div>
					<div class="xmgs_tab">
						<a href="./show_index.jsp"> <span data-id="-1"
							class="xmgsyabHover2">意向等级公示<font></font></span>
						</a> <a href="./family_result.jsp"> <span data-id="-1"
							class="xmgsyabHover">摇号家庭公示<font></font></span>
						</a> <a href="./select_num_result.jsp"> <span data-id="2"
							class="xmgsyabHover">摇号结果公示<font></font></span>
						</a> <a href="./select_hosue_show.jsp"> <span data-id="6"
							class="xmgsyabHover">选房结果公示<font></font></span>
						</a> <a href="./index.jsp">
							<div class="myyxdjBtn">返回首页</div>
						</a>
					</div>
					<script type="text/javascript">
                        $(".xmgs_tab .zzdj").each(function () {
                            if ($(this).find("font").text() == "(0)") {
                                $(this).hide();
                            }
                        })
                    </script>
				</div>
				<div class="mag_b10 prel pad_10 pad_t25">
					<input type="submit" name="btnSubmit" value="" id="btnSubmit"
						disabled="disabled" class="aspNetDisabled" style="display: none;">
					<div class="prel xmmcSearchDiv">
						<span class="mag_r10">项目名称</span> <input class="xmmcSearch"
							type="text" value="" id="txtSearch"
							onkeypress="search(window.event?event.keyCode:event.which,&#39;xmgs.aspx&#39;)">
						<div class="xmgs_searchBtn"
							onclick="search(13,&#39;xmgs.aspx&#39;)">搜索</div>
						<!-- <div id="divDayDjsj" class="pab right_20 size14 top_8 color_999999">登记时间为：08:00-18:00</div> -->
					</div>
				</div>
				<div class="grayLine"></div>
				<table class="tab" width="1200" align="center" cellpadding="0"
					cellspacing="0">
					<tbody>
						<tr>
							<td align="center" bgcolor="#e7e3e3"><table width="1200"
									cellspacing="0" cellpadding="0" style="table-layout: fixed;">
									<tbody>
										<tr>
											<td align="center" bgcolor="#e7e3e3"><span
												class="sale_show/css/main.css.fb">序号</span></td>
											<td align="center" bgcolor="#e7e3e3"><span class="fb">用户名</span></td>
											<td align="center" bgcolor="#e7e3e3" colspan="2"><span
												class="fb">用户姓名</span></td>
											<td align="center" bgcolor="#e7e3e3" colspan="2"><span
												class="fb">身份证号</span></td>
											<td align="center" bgcolor="#e7e3e3" colspan="2"><span
												class="fb">联系方式</span></td>
											<td align="center" bgcolor="#e7e3e3"><span class="fb">摇号时间</span></td>
										</tr>
										<tr>
											<td>
												<hr width="1198" color="blue">
											</td>
										</tr>
										<tr>
											<td align="center">1</td>
											<td align="center">哈哈哈</td>
											<td align="center" colspan="2">李乐莉</td>
											<td align="center" colspan="2">610527********2345</td>
											<td align="center" colspan="2">151****0323</td>
											<td align="center">待定</td>
										</tr>


										<tr>
											<td>
												<hr width="1198" color="blue">
											</td>
										</tr>

									</tbody>
								</table>
								 <script type="text/javascript"> xmgsload();</script>

								<link href="./sale_show/css/footer.css" rel="stylesheet">
							<div class="w2017">
								<div style="width: 80%; height: 10px;"></div>
								<div class="footer" style="width: 1200px; margin: auto;">
									<div class="footer">
										<div class="section">
											<div class="copyright">
												<div class="mark1"></div>
												<div class="link2017">
													<p style="font-size: 18px; text-align: left;">版权所有：@西安工业大学实习实训第4组</p>
													<p style="font-size: 18px; text-align: left;">
														网站标识码：8686868686<em></em>
													</p>
													<p style="font-size: 18px;">
														网站技术支持热线：029-8686866<em></em>工作日：9:00-12:00，14:00-18:00（夏令时：15:00-18:00）
													</p>
												</div>
											</div>
											<div class="clr"></div>
										</div>
									</div>
								</div>
</body>
</html>