function deleteStudent(id) {
    swal({
        title: "Are you sure?",
        text: "Once deleted, you will not be able to recover this Student!",
        icon: "warning",
        buttons: true,
        dangerMode: true,
    })
        .then((willDelete) => {
            if (willDelete) {
                $.ajax({
                    url: "/students/delete-ajax",
                    type: "POST",
                    data: {'id': id},
                    success: function () {
                        $("#" + id).remove();
                        swal("Poof! Your Student has been deleted!", {
                            icon: "success",
                        });
                    }
                });
            } else {
                swal("Your Student is safe!");
            }
        });
}