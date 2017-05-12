<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>
<style type="text/css">
.footbar {
    background-color: #ffffff;
    text-align: center;
    font-size: 18px;
    background: #FFFFFF;
}

a {
    color: #000000;
    text-decoration: none;
}

.blackFont {
    color: #222222;
}

.foot_img {
    width: 15%;
    height: 15%;
}


/* Alignment */

.alignleft {
    display: inline;
    float: left;
}

.alignright {
    display: inline;
    float: right;
}

.aligncenter {
    clear: both;
    display: block;
    margin: auto;
}

.tdcenter {
    text-align: center;
}
</style>
<div class="row clearfix" style="margin-top: 50px;">
    <div class="col-xs-12 column">
        <nav class="navbar navbar-default navbar-fixed-bottom" role="navigation">
            <div class="footbar" style="height:auto; border:0px; padding:10px;">
                <table border="0" cellpadding="0" cellspacing="0" width="100%">
                    <tr>
                        <td class="tdcenter" style="width:20%;">
                            <div>
                                <a href="showGoodsController"><img class="foot_img aligncenter" alt="首页" src="images/home.png" /></a>
                            </div>
                        </td>
                        <td class="tdcenter" style="width:20%;">
                            <div>
                                <a href="collectionListController?collectionStatus=1"><img class="foot_img aligncenter" alt="收藏" src="images/heart.png" /></a>
                            </div>
                        </td>
                        <td class="tdcenter" style="width: 20%;">
                            <div>
                                <a href="goodInputController"><img class="foot_img aligncenter" alt="发布" src="images/plus.png" /></a>
                            </div>
                        </td>
                        <td class="tdcenter" style="width: 20%;">
                            <div>
                                <a href="goodListController"><img class="foot_img aligncenter" alt="所有发布" src="images/product_list.png" /></a>
                            </div>
                        </td>
                        <td class="tdcenter" style="width: 20%;">
                            <div>
                                <a href="userInfoController"><img class="foot_img aligncenter" alt="个人" src="images/me.png" /></a>
                            </div>
                        </td>
                    </tr>
                </table>
            </div>
        </nav>
    </div>
</div>

