let dataTable;
let dataTableIsInitialized = false;

const dataTableOptions = {
    scrollX: true,
    lengthMenu: [5, 10, 15, 20, 100, 200, 500],
    columnDefs: [
        {className: "centered", targets: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17]},
        {orderable: false, targets: [18, 19]},
        {searchable: false, targets: [18, 19]}
        //{ width: "50%", targets: [0] }
    ],
    pageLength: 10,
    destroy: true,
    language: {
        lengthMenu: "Mostrar _MENU_ registros por página",
        zeroRecords: "Ningún registro encontrado",
        info: "Mostrando de _START_ a _END_ de un total de _TOTAL_ registros",
        infoEmpty: "Ningún registro encontrado",
        infoFiltered: "(filtrados desde _MAX_ registros totales)",
        search: "Buscar:",
        loadingRecords: "Cargando...",
        paginate: {
            first: "Primero",
            last: "Último",
            next: "Siguiente",
            previous: "Anterior"
        }

    }

};

const initDataTable = async () => {
    if (dataTableIsInitialized) {
        dataTable.destroy();
    }

    dataTable = $("#datatable_users").DataTable(dataTableOptions);

    dataTableIsInitialized = true;
};

$(document).ready(function () {
    initDataTable();
});

function actualizarFechaHora() {
    const fechaHora = document.getElementById("fechaHora");
    const ahora = new Date();
    const dia = String(ahora.getDate()).padStart(2, "0");
    const mes = String(ahora.getMonth() + 1).padStart(2, "0");
    const anio = ahora.getFullYear();
    const horas = String(ahora.getHours()).padStart(2, "0");
    const minutos = String(ahora.getMinutes()).padStart(2, "0");
    fechaHora.textContent = `Estamos a ${dia}/${mes}/${anio} a las ${horas}:${minutos}`;
}
actualizarFechaHora();