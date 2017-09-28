/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(function()
{
    $("#productRegister").click(productRegister);
        function productRegister()
        {
            var productCode = $("#productCode").val();
            var productName = $("#productName").val();
            var productPrice = $("#productPrice").val();
            var productQuantity = $("#productQuantity").val();
            if (productCode !== null && productName !== null && productPrice !== null && productQuantity !== null)
            {
                $.post("Controller1",
                        {
                            operation: "productRegister",
                            productCode: productCode,
                            productName: productName,
                            productPrice: productPrice,
                            productQuantity: productQuantity
                        },
                        function (data)
                        {
                            if (data)
                            {
                                alert("Se registro correctamente el producto");
                            } else
                            {
                                alert("Error al registrar producto");
                            }
                        }, "json");
            } else
            {
                alert("Existe algun campo vacio");
            }
        }
});


