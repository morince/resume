<div class="n-head">
    <div class="g-doc f-cb">
        <div class="user">
        <#if user>
            <#if user.userType==1>游客<#else>管理员</#if><span class="name">${user.userName}</span> &nbsp  Welcome！<a href="/logout">[退出]</a>
        <#else>
            请<a href="/login">[登录]</a>
        </#if>
        </div>
        <ul class="nav">
            <li><a href="/">首页</a></li>
            <#if user && user.userType==0>
            <li><a href="/account">账务</a></li>
            </#if>
            <#if user && user.userType==1>
            <li><a href="/public">发布</a></li>
            </#if>
        </ul>
    </div>
</div>