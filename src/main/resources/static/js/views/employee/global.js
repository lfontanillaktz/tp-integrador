$(document).ready(function () {

    $(".open-deleteemployeedialog").click(function () {
        $('#employeeIdDeleteModal').val($(this).data('id'));
        $('#deleteModal').modal('show');
    });

    $(".open-editemployeedialog").click(function () {
        $('#employeeIdEditModal').val($(this).data('id'));
        $('#employeeNameEditModal').val($(this).data('name'));
        $('#employeeLastNameEditModal').val($(this).data('lastname'));
        $('#employeeSeniorityEditModal').val($(this).data('seniority')).change();
        $('#employeeProjectEditModal').val($(this).data('projectid')).change();
        $('#editModal').modal('show');
    });

});