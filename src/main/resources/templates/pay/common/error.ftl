<html>
<head>
    <meta charset = "utf-8">
    <title>卖家错误提示</title>
    <link href="https://cdn.bootcss.com/twitter-bootstrap/3.0.1/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="alert alert-dismissable alert-danger">
                <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
                <h4>
                    Error!
                </h4> <strong>${msg}!</strong><a href="${url}" class="alert-link">Page will be redirected in 3s.</a>
            </div>
        </div>
    </div>
</div>
</body>
<script>
    setTimeout('location.href="${url}"', 3000);
</script>
</html>