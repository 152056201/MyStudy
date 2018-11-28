function getAjax(ele) {
    new Promise((resolve, reject) => {
        $.ajax({
            methods: "get",
            url: "./txt/index.txt",
            dataType: "json",
            success(data) {
                console.log("接收成功");
                resolve(data);
            },
            error(err) {
                console.log("接收失败");
                reject(err);
            }
        })
    })
        .then(value => {
            [].slice.call(value).forEach(item => {
                let tr = document.createElement("tr"),
                    subStr = `
                                <td>${item.studentId}</td>
                                <td>${item.studentName}</td>
                                <td>${item.studentSex}</td>
                                <td>${item.studentBirth}</td>
                                <td>${item.studentAddress}</td>
                                `;
                tr.innerHTML = subStr;
                ele.tBodies[0].appendChild(tr);
            })
        }, err => {
            alert(err.status);
        })
        .catch(err => {
            alert(err);
        })

}

window.onload = function () {
    changeColor();
    watchList();
    scrollBar();
    //1.隔行变色
    function changeColor() {
        let oTable = document.querySelector("table");
        for (let i = 0, oTr = oTable.tBodies[0].rows; i < oTr.length; i++) {
            if (i % 2 === 0) {
                oTr[i].style.backgroundColor = "#EEEEEE";
            }
        }
    }
    //2.滚动条的隐藏与显示
    function scrollBar() {
        $.ajax({
            dataType: "json",
            methods: "get",
            url:"./txt/index.txt",
            success(data){
                if (data.length<=13){
                   $("table").children(":last").css("overflow-y","hidden");
                }
            },
            error(err){
                console.log(err.status);
            }
        })

    }
    //3.浏览
    function watchList() {
           let oTable = document.querySelector("table");
        $("input:first").click(function () {
            getAjax(oTable);
        })
    }


}