$(document).ready(function () {

    $(".open-deleteclientdialog").click(function () {
        $('#clientIdDeleteModal').val($(this).data('id'));
        $('#deleteModal').modal('show');
    });

    $(".open-editclientdialog").click(function () {
        $('#clientIdEditModal').val($(this).data('id'));
        $('#clientNameEditModal').val($(this).data('name'));
        $('#editModal').modal('show');
    });

});