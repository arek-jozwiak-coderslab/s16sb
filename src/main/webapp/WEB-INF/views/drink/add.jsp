<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">Dashboard</h1>
        </div>
        <!-- /.col-lg-12 -->
    </div>
    <!-- /.row -->

    <!-- /.row -->
    <div class="row">

        <div class="panel panel-default">
            <div class="panel-heading">
                Heros list
            </div>
            <!-- /.panel-heading -->
            <div class="panel-body">
                <form:form modelAttribute="drink" enctype="multipart/form-data">
                    <div class="form-group">
                        <label>Name:</label>
                        <form:input path="name" cssClass="form-control"/>
                        <form:errors path="name" cssClass="error"/>
                    </div>

                    <div class="form-group">
                        <input type="file" name="file"/>
                    </div>
                    <div class="form-group">
                        <button type="submit" class="btn btn-default">Submit Button</button>
                    </div>
                </form:form>

            </div>
            <!-- /.panel-body -->
        </div>

    </div>
    <!-- /.row -->

<!-- /#page-wrapper -->

