// tabs 初始就一个仪表盘
var showTabs = [];
let indexObj = {
  url: "pages/test/validator.html",
  name: "仪表盘",
  standup: true
};
showTabs.push(indexObj)
$(function () {
  $.ajaxSettings.async = false;
  $.getJSON('/menu.json', function (data) {
    var str1 = "";
    var str2 = "";
    let result = data.data;
    for (var i = 0; i < result.length; i++) {
      if (result[i].url == null && result[i].menuTitle != null) {
        str1 += `<li class="app-sidebar__heading">${result[i].menuTitle}</li>
            <li>
                  <a href="#">
                  <i class="${result[i].icon}"></i>
                  ${result[i].name}
                  <i class="metismenu-state-icon pe-7s-angle-down caret-left"></i>
                </a>
                <ul class="mm-collapse">
                  <li class="${result[i].id}">

                  </li>
                </ul>
                </li>`
        $(".loadMenu").append(str1);
        str1 = "";
        id = `${result[i].parentId}`
      }
      else if (result[i].url == null) {
        str1 += `
            <li>
                  <a href="#">
                  <i class="${result[i].icon}"></i>
                  ${result[i].name}
                  <i class="metismenu-state-icon pe-7s-angle-down caret-left"></i>
                </a>
                <ul class="mm-collapse">
                  <li class="${result[i].id}">

                  </li>
                </ul>
                </li>`
        $(".dd").append(str1);
        str1 = "";
        id = `${result[i].parentId}`
      }
      if (result[i].url != null) {
        str2 += `
                    <a onclick="showContent(this)" data-submenu=${JSON.stringify(result[i])} href="javascript:void(0);">
                      <i class="metismenu-icon"></i>
                      ${result[i].name}
                    </a>
                  `
        $("." + `${result[i].parentId}`).append(str2);
        str2 = "";
      }
    }

    // 一开始渲染仪表盘
    renderSubMenu(indexObj.url);

    $("#footer").load("/pages/footer.html");
    showContent = (dom) => {
      let submenuObj = JSON.parse(dom.dataset.submenu);
      let path = submenuObj.url;
      if (!isExist(path)) {
        submenuObj.standup = true
        showTabs.push(submenuObj)
      }
      renderSubMenu(path);
      isRightBtnShow()
    }
    //  前进后退选项是否显示
    window.onresize = function () {
      isRightBtnShow()
    }
    function isRightBtnShow() {
      let innerW = $("#tabs").width();
      let outerW = $("#tabParent").width();
      if (innerW + 70 >= outerW) {
        $("#rightArrow").show()
        $("#leftArrow").show()
      } else {
        $("#rightArrow").hide()
        $("#leftArrow").hide()
        $("#tabs").css("left", "0px")
      }
    }

    // 前进后退事件
    //右箭头
    let distance = 0;
    $("#rightArrow").on("click", (e) => {
      let w1 = $("#tabs").css("left")
      let w2 = $("#tabs").width();
      let N = Math.abs(parseInt(w1))
      if (e.target == $("#rightArrow")[0]) {
        distance -= 100
        $("#tabs").css("left", distance + "px")

      }
      if (e.target == $("#rightArrow")[0] && N + 320 >= w2) {
        distance = parseInt(w1)
        $("#tabs").css("left", distance + "px")
      }

    })
    //左箭头
    $("#leftArrow").on("click", (e) => {
      if (e.target == $("#leftArrow")[0]) {
        distance += 100
        if (distance >= 0) {
          distance = 0
        }
        $("#tabs").css("left", distance + "px")
      }
    })

    // tabs事件
    $("#tabs").on("click", "li", (e) => {
      let url = e.currentTarget.dataset.url;
      if ($(e.currentTarget).find("p").last()[0] == e.target) {
        // 删
        removeTabAndIframe(url)
      } else {
        hideAllIframeShowActive(url)
        activeTabShow(url)
      }

    })

    // 删除
    function removeTabAndIframe(path) {

      $("#content").find("iframe").each((i, v) => {
        if (v.dataset.url == path) {
          $(v).remove()
        }
      })
      $("#tabs").find("li").each((i, v) => {
        if (v.dataset.url == path) {
          if ($(v).hasClass("tabActive")) {
            $("#tabs").find("li").eq(0).addClass("tabActive")
            $("#content").find("iframe").eq(0).show()
          }
          $(v).remove()
        }
      })
      // 数组也要去
      for (let i = 0; i < showTabs.length; i++) {
        let item = showTabs[i];
        if (item.url == path) {
          showTabs.splice(i, 1);
        }
      }
      // 前进后退按钮是否隐藏
      isRightBtnShow()
    }

    // 渲染
    function renderSubMenu(path) {
      // $("#tabs").html("")
      // $("#content").html("")
      showTabs.forEach(v => {
        if (v.standup) {
          let tab_s = `<li data-url="${v.url}" class="tabActive"><p>${v.name}</p><p>×</p></li>`;
          if (v.name == "仪表盘") {
            tab_s = `<li data-url="${v.url}"><p><i class="pe-7s-home" style="font-size: 20px; margin-right: 5px;"></i>仪表盘</p><p style="display: none"></p></li>`
          }
          $("#tabs").append(tab_s);
          let iframe_s = `<iframe src=${path} data-url="${v.url}" width="100%" height="100%" frameborder="0" style="display: none" ></iframe>`
          $("#content").append(iframe_s)
          v.standup = false
        }

      })
      hideAllIframeShowActive(path)
      activeTabShow(path)
    }

    // 是否存在
    function isExist(path) {
      for (let i = 0; i < showTabs.length; i++) {
        if (showTabs[i].url == path) {
          return true;
        }
      }
      return false;
    }

    // 独显iframe
    function hideAllIframeShowActive(path) {
      $("#content").find("iframe").hide()
      $("#content").find("iframe").each((i, v) => {
        let attribute = v.getAttribute("src");
        if (attribute == path) {
          $(v).show()
        }
      })
    }

    // 独显tab样式
    function activeTabShow(path) {
      $("#tabs").find("li").each((i, v) => {
        $(v).removeClass("tabActive")
        if (path == v.dataset.url) {
          $(v).addClass("tabActive")
        }
      })
    }




  })
})


