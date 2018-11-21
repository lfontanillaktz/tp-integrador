$(document).ready(function () {

    $(".open-deleteprojectdialog").click(function () {
        $('#projectIdDeleteModal').val($(this).data('id'));
        $('#deleteModal').modal('show');
    });

    $(".open-editprojectdialog").click(function () {
        $('#projectIdEditModal').val($(this).data('id'));
        $('#projectNameEditModal').val($(this).data('name'));
        $('#projectDateEditModal').val($(this).data('date'));
        $('#projectClientEditModal').val($(this).data('clientid')).change();
        $('#editModal').modal('show');
    });

});