/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function () {

    $.post("Controller1",
            {
                operation: "productShow"
            },
            function (data)
            {
                if (data !== null)
                {
                    var productTable = $("#productTable");
                    for (var i = 0; i < data.length; i++) {
                        var productId = data[i].productId;
                        var productCode = data[i].productCode;
                        var productName = data[i].productName;
                        var productPrice = data[i].productPrice;
                        var productQuantity = data[i].productQuantity;
                        var tr = $("<tr>");
                        var td1 = $("<td>", {text: productId});
                        var td2 = $("<td>", {text: productCode});
                        var td3 = $("<td>", {text: productName});
                        var td4 = $("<td>", {text: productPrice});
                        var td5 = $("<td>", {text: productQuantity});
                        tr.append(td1);
                        tr.append(td2);
                        tr.append(td3);
                        tr.append(td4);
                        tr.append(td5);
                        productTable.append(tr);
                    }
                } else
                {
                    alert("Error al mostrar productos");
                }
            }, "json");
    }
);

