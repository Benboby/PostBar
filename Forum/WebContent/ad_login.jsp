<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <title>管理员登录</title>
    <link rel="stylesheet" href="css/login.css">
</head>
<body>

<div class="main">
    <form action="User" method="post">
        <div class="loginFrame">
            <p class="loginTitle">AD Login</p>
            <div class="user">
                <label>
                    <span>
                        <svg class="icon" height="20" p-id="3807" t="1586442913188"
                             version="1.1" viewBox="0 0 1024 1024" width="20" xmlns="http://www.w3.org/2000/svg"><path
                                d="M517.632 552.149333c-108.714667 0-197.162667-85.546667-197.162667-190.72 0-38.314667 11.690667-75.306667 33.877334-106.922666C391.04 202.026667 452.138667 170.666667 517.632 170.666667c65.408 0 126.464 31.274667 163.2 83.712 7.765333 11.093333 14.250667 22.869333 19.413333 35.072a21.333333 21.333333 0 1 1-39.338666 16.64 147.285333 147.285333 0 0 0-15.018667-27.221334C617.130667 237.824 569.173333 213.333333 517.632 213.333333c-51.626667 0-99.584 24.533333-128.426667 65.621334a143.445333 143.445333 0 0 0-26.069333 82.432c0 81.664 69.290667 148.096 154.453333 148.096 63.402667 0 119.722667-36.437333 143.36-92.8a21.333333 21.333333 0 0 1 39.338667 16.512c-30.378667 72.277333-102.016 118.954667-182.656 118.954666"
                                fill="#ffffff" p-id="3808"></path><path
                                d="M303.829333 627.456c-49.92 0-90.453333 41.088-90.453333 91.605333C213.333333 769.578667 253.866667 810.666667 303.786667 810.666667h416.341333C770.133333 810.666667 810.666667 769.578667 810.666667 719.061333c0-50.517333-40.533333-91.605333-90.453334-91.605333H303.786667zM720.213333 853.333333H303.829333C230.442667 853.333333 170.709333 793.088 170.709333 719.061333 170.666667 645.034667 230.4 584.789333 303.786667 584.789333h416.341333C793.6 584.789333 853.333333 645.034667 853.333333 719.061333 853.333333 793.088 793.6 853.333333 720.213333 853.333333z"
                                fill="#ffffff" p-id="3809"></path></svg>
                    </span>
                    <span>用户名</span>
                    <input maxlength="16" placeholder="   UserName" type="text" name="username">
                </label>
            </div>
            <div class="password">
                <label>
                    <span>
                        <svg class="icon" height="20" p-id="4677" t="1586443029761"
                             version="1.1" viewBox="0 0 1024 1024" width="20" xmlns="http://www.w3.org/2000/svg"><path
                                d="M511.176404 551.030949c-38.584889 0-69.974626 31.392323-69.974626 69.979798 0 15.341899 4.874343 29.909333 14.105859 42.121051 0.192646 0.261172 0.404687 0.513293 0.616727 0.768 17.287758 20.146424 18.545778 34.525091 18.620768 35.842586l0 39.965737c0 20.20202 16.434424 36.631273 36.631273 36.631273 20.20202 0 36.632566-16.434424 36.632566-36.631273l0-40.718222c0-0.457697-0.015515-0.919273-0.060768-1.373091 0-0.03103 0.090505-0.005172 0.095677-0.040081 0.100848-0.919273 0.408566-2.884525 1.343354-5.727677 1.883798-5.712162 6.30303-15.080727 16.707232-27.24202 0.151273-0.177131 0.297374-0.359434 0.439596-0.540444 9.702141-12.399192 14.828606-27.288566 14.828606-43.055838C581.161374 582.424566 549.767758 551.030949 511.176404 551.030949L511.176404 551.030949zM541.580929 644.313212c-24.46998 28.748283-25.667232 49.334303-25.434505 55.091717l0 40.308364c0 2.737131-2.232889 4.963556-4.97002 4.963556-2.737131 0-4.964848-2.226424-4.964848-4.963556L506.211556 699.552323c0-2.954343-0.81196-26.410667-25.903838-55.858424-4.873051-6.601697-7.444687-14.429091-7.444687-22.681859 0-21.126465 17.186909-38.319838 38.313374-38.319838 21.131636 0 38.323717 17.193374 38.323717 38.319838C549.500121 629.536323 546.76299 637.586101 541.580929 644.313212L541.580929 644.313212zM541.580929 644.313212"
                                fill="#ffffff" p-id="4678"></path><path
                                d="M777.580606 417.122263l-1.989818 0 0-0.232727-36.848485 0 0-101.520808c0-0.67103-0.045253-1.343354-0.126707-2.014384-6.923636-54.061253-33.298101-103.833859-74.272323-140.166465C623.009616 136.546263 569.792646 116.363636 514.505697 116.363636c-60.353939 0-117.095434 23.505455-159.773737 66.177293-42.67701 42.67701-66.176 99.419798-66.176 159.772444l0 74.78303-43.132121 0.025859c-29.812364 0-54.070303 24.256646-54.070303 54.070303l0 383.171232c0 29.818828 24.257939 54.071596 54.070303 54.071596l330.369293 0c0.479677 0 0.954182-0.020687 1.424808-0.065939l198.93398 0c0.469333 0.045253 0.943838 0.065939 1.428687 0.065939 29.808485 0 54.065131-24.252768 54.065131-54.071596L831.645737 471.192566C831.64703 441.378909 807.394263 417.122263 777.580606 417.122263L777.580606 417.122263zM320.246949 342.313374c0-51.889131 20.207192-100.671354 56.899232-137.358222 36.686869-36.69204 85.470384-56.899232 137.358222-56.899232 47.530667 0 93.282263 17.348525 128.806788 48.848162 34.990545 31.021253 57.597414 73.420283 63.733657 119.489939l0 100.495515-386.799192 0.232727L320.245657 342.313374 320.246949 342.313374zM799.954747 854.363798c0 11.773414-9.135838 21.449697-20.69204 22.313374l-0.126707 0L245.423838 876.739232c-12.338424 0-22.37802-10.03701-22.37802-22.375434L223.045818 471.192566c0-12.338424 10.039596-22.379313 22.37802-22.379313l58.984727-0.029737c0.808081 0 1.596768-0.081455 2.373818-0.196525 0.849455 0.135758 1.71701 0.231434 2.606545 0.231434l299.146343 0c0.288323 0.005172 0.731798 0.015515 1.313616 0.015515 1.247677 0 3.152162-0.029737 5.590626-0.156444l105.742222 0c0.656808 0.080162 1.322667 0.135758 2.000162 0.135758l54.398707 0c12.333253 0 22.374141 10.046061 22.374141 22.379313L799.954747 854.363798 799.954747 854.363798zM799.954747 854.363798"
                                fill="#ffffff" p-id="4679"></path></svg>
                    </span>
                    <span>密码</span>
                    <input maxlength="16" placeholder="   Password" type="password" name="password">
                </label>
            </div>
             <div class="regBut">
                <a href="u_login.jsp" style="color: #DDDFE4; font-size: 12px">用户登录</a>
            </div>
             <div class="tourBut">
                <a href="index.jsp" style="color: #DDDFE4; font-size: 12px">游客登录</a>
            </div>
            <div class="logBut">
                <input style="border-bottom: 0px; font-size: 15px" type="submit" name="ADloginBut" value="登录"/>
            </div>
        </div>
    </form>
</div>
</body>
</html>
