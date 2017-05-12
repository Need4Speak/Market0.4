<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>
<style type="text/css">
body {
    background-color: #efefef;
}

.footbar {
    background-color: #ffffff;
    text-align: center;
    font-size: 18px;
    background:#FFFFFF;
}

a {
    color: #000000;
    text-decoration: none;
}

.blackFont {
	color: #222222;
}
.foot_img {
	width:10%; 
    height:10%; 
}
</style>
<nav class="navbar navbar-default navbar-fixed-bottom" role="navigation">
    <div class="footbar" style="height:auto; border:0px; padding:10px;">
        <table border="0" cellpadding="0" cellspacing="0" width="100%">
            <tr>
                <td style="width:20%;">
                    <div>
                        <a href="showGoodsController"><span class="blackFont"><img class="foot_img" alt="首页" src="images/home.png" /></span></a>
                    </div>
                </td>
                <td style="width:20%;">
                    <div>
                        <a href="collectionListController?collectionStatus=1"><img class="foot_img" alt="收藏" src="images/heart.png" /></a>
                    </div>
                </td>
                <td style="width: 20%;">
                    <div>
                        <a href="goodInputController"><img class="foot_img" alt="发布" src="images/plus.png" /></a>
                    </div>
                </td>
                <td style="width: 20%;">
                    <div>
                        <a href="goodListController"><img class="foot_img" alt="所有发布" src="images/product_list.png" /></a>
                    </div>
                </td>
                <td style="width: 20%;">
                    <div>
                        <a href="userInfoController"><img class="foot_img" alt="个人" src="images/me.png" /></a>
                    </div>
                </td>
            </tr>
        </table>
    </div>
</nav>
