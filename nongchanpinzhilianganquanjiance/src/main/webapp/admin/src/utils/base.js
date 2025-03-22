const base = {
    get() {
        return {
            url : "http://localhost:8080/nongchanpinzhilianganquanjiance/",
            name: "nongchanpinzhilianganquanjiance",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/nongchanpinzhilianganquanjiance/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "农产品质量安全检测"
        } 
    }
}
export default base
