
$(function(){
    $("#distpicker").distpicker('destroy');
    $("#distpicker").distpicker({
        province: '省份名',
        city: '城市名',
        district: '区名',
        autoSelect: true,
        placeholder: false
    });
});
$("#eprovinceName").val(data.provinceName);
$("#eprovinceName").trigger("change");
$("#ecityName").val(data.cityName);
$("#ecityName").trigger("change");
$("#edistrictName").val(data.districtName);
$("#edetailAddress").val(data.detailAddress);