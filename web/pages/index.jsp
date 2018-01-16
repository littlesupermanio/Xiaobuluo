<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>论坛首页</title>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link href="../css/bootstrap.min.css" rel="stylesheet" />
    <link href="../css/styles.css" rel="stylesheet"/>
</head>
<body>
    <div class="row">
        <div class="col">
            <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
                <div class="col-md-3">
                    <a class="navbar-brand float-right" href="#">小部落</a>
                    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarColor02" aria-controls="navbarColor02" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                </div>

                <div class="col-md-9">
                    <div class="collapse navbar-collapse" id="navbarColor02">
                        <ul class="navbar-nav mr-auto">
                            <li class="nav-item active">
                                <a class="nav-link" href="#">首页 <span class="sr-only">(current)</span></a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#">话题</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#">用户中心</a>
                            </li>
                        </ul>
                        <form class="form-inline">
                            <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
                            <button class="btn btn-outline-light my-2 my-sm-0" type="submit">搜索</button>
                        </form>
                    </div>
                </div>
            </nav>
        </div>
    </div>

    <div class="container">
        <div class="row">
            <ul class="nav nav-pills mb-3" id="pills-tab" role="tablist">
                <li class="nav-item">
                    <a class="nav-link active" aria-selected="true">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" aria-selected="false">Profile</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link"  role="tab" aria-controls="pills-contact" aria-selected="false">Contact</a>
                </li>
            </ul>
            <div class="tab-content" id="pills-tabContent">
                <div class="tab-pane fade show active" id="pills-home" role="tabpanel" aria-labelledby="pills-home-tab">...</div>
                <div class="tab-pane fade" id="pills-profile" role="tabpanel" aria-labelledby="pills-profile-tab">...</div>
                <div class="tab-pane fade" id="pills-contact" role="tabpanel" aria-labelledby="pills-contact-tab">...</div>
            </div>
        </div>
    </div>
</body>



<script src="../js/jquery-3.2.1.min.js"></script>
<script src="https://cdn.bootcss.com/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="../js/bootstrap.js"></script>


</html>
