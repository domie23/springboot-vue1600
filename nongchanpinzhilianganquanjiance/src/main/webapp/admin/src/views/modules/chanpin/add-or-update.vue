<template>
    <div class="addEdit-block">
        <el-form
                class="detail-form-content"
                ref="ruleForm"
                :model="ruleForm"
                :rules="rules"
                label-width="80px"
                :style="{backgroundColor:addEditForm.addEditBoxColor}">
            <el-row>
                <input id="updateId" name="id" type="hidden">
               <el-col :span="12">
                   <el-form-item class="input" v-if="type!='info'"  label="追溯码" prop="chanpinUuidNumber">
                       <el-input v-model="ruleForm.chanpinUuidNumber"
                                 placeholder="追溯码" clearable  :readonly="ro.chanpinUuidNumber"></el-input>
                   </el-form-item>
                   <div v-else>
                       <el-form-item class="input" label="追溯码" prop="chanpinUuidNumber">
                           <el-input v-model="ruleForm.chanpinUuidNumber"
                                     placeholder="追溯码" readonly></el-input>
                       </el-form-item>
                   </div>
               </el-col>
               <el-col :span="12">
                   <el-form-item class="input" v-if="type!='info'"  label="产品名称" prop="chanpinName">
                       <el-input v-model="ruleForm.chanpinName"
                                 placeholder="产品名称" clearable  :readonly="ro.chanpinName"></el-input>
                   </el-form-item>
                   <div v-else>
                       <el-form-item class="input" label="产品名称" prop="chanpinName">
                           <el-input v-model="ruleForm.chanpinName"
                                     placeholder="产品名称" readonly></el-input>
                       </el-form-item>
                   </div>
               </el-col>
                <el-col :span="12">
                    <el-form-item class="select" v-if="type!='info'"  label="产品类型" prop="chanpinTypes">
                        <el-select v-model="ruleForm.chanpinTypes" :disabled="ro.chanpinTypes" placeholder="请选择产品类型">
                            <el-option
                                v-for="(item,index) in chanpinTypesOptions"
                                v-bind:key="item.codeIndex"
                                :label="item.indexName"
                                :value="item.codeIndex">
                            </el-option>
                        </el-select>
                    </el-form-item>
                    <div v-else>
                        <el-form-item class="input" label="产品类型" prop="chanpinValue">
                        <el-input v-model="ruleForm.chanpinValue"
                            placeholder="产品类型" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="24">
                    <el-form-item class="upload" v-if="type!='info' && !ro.chanpinPhoto" label="产品图片" prop="chanpinPhoto">
                        <file-upload
                            tip="点击上传产品图片"
                            action="file/upload"
                            :limit="3"
                            :multiple="true"
                            :fileUrls="ruleForm.chanpinPhoto?ruleForm.chanpinPhoto:''"
                            @change="chanpinPhotoUploadChange"
                        ></file-upload>
                    </el-form-item>
                    <div v-else>
                        <el-form-item v-if="ruleForm.chanpinPhoto" label="产品图片" prop="chanpinPhoto">
                            <img style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in (ruleForm.chanpinPhoto || '').split(',')" :src="item" width="100" height="100">
                        </el-form-item>
                    </div>
                </el-col>
               <el-col :span="12">
                   <el-form-item class="input" v-if="type!='info'"  label="种植企业" prop="chanpinZhongzhi">
                       <el-input v-model="ruleForm.chanpinZhongzhi"
                                 placeholder="种植企业" clearable  :readonly="ro.chanpinZhongzhi"></el-input>
                   </el-form-item>
                   <div v-else>
                       <el-form-item class="input" label="种植企业" prop="chanpinZhongzhi">
                           <el-input v-model="ruleForm.chanpinZhongzhi"
                                     placeholder="种植企业" readonly></el-input>
                       </el-form-item>
                   </div>
               </el-col>
               <el-col :span="12">
                   <el-form-item class="input" v-if="type!='info'"  label="加工企业" prop="chanpinJiagong">
                       <el-input v-model="ruleForm.chanpinJiagong"
                                 placeholder="加工企业" clearable  :readonly="ro.chanpinJiagong"></el-input>
                   </el-form-item>
                   <div v-else>
                       <el-form-item class="input" label="加工企业" prop="chanpinJiagong">
                           <el-input v-model="ruleForm.chanpinJiagong"
                                     placeholder="加工企业" readonly></el-input>
                       </el-form-item>
                   </div>
               </el-col>
               <el-col :span="12">
                   <el-form-item class="input" v-if="type!='info'"  label="运输企业" prop="chanpinYunshu">
                       <el-input v-model="ruleForm.chanpinYunshu"
                                 placeholder="运输企业" clearable  :readonly="ro.chanpinYunshu"></el-input>
                   </el-form-item>
                   <div v-else>
                       <el-form-item class="input" label="运输企业" prop="chanpinYunshu">
                           <el-input v-model="ruleForm.chanpinYunshu"
                                     placeholder="运输企业" readonly></el-input>
                       </el-form-item>
                   </div>
               </el-col>
               <el-col :span="12">
                   <el-form-item class="input" v-if="type!='info'"  label="销售企业" prop="chanpinXiaoshou">
                       <el-input v-model="ruleForm.chanpinXiaoshou"
                                 placeholder="销售企业" clearable  :readonly="ro.chanpinXiaoshou"></el-input>
                   </el-form-item>
                   <div v-else>
                       <el-form-item class="input" label="销售企业" prop="chanpinXiaoshou">
                           <el-input v-model="ruleForm.chanpinXiaoshou"
                                     placeholder="销售企业" readonly></el-input>
                       </el-form-item>
                   </div>
               </el-col>
               <el-col :span="12">
                   <el-form-item class="input" v-if="type!='info'"  label="主要原材料" prop="chanpinYuancailiao">
                       <el-input v-model="ruleForm.chanpinYuancailiao"
                                 placeholder="主要原材料" clearable  :readonly="ro.chanpinYuancailiao"></el-input>
                   </el-form-item>
                   <div v-else>
                       <el-form-item class="input" label="主要原材料" prop="chanpinYuancailiao">
                           <el-input v-model="ruleForm.chanpinYuancailiao"
                                     placeholder="主要原材料" readonly></el-input>
                       </el-form-item>
                   </div>
               </el-col>
               <el-col :span="12">
                   <el-form-item class="input" v-if="type!='info'"  label="种子" prop="chanpinZhongzi">
                       <el-input v-model="ruleForm.chanpinZhongzi"
                                 placeholder="种子" clearable  :readonly="ro.chanpinZhongzi"></el-input>
                   </el-form-item>
                   <div v-else>
                       <el-form-item class="input" label="种子" prop="chanpinZhongzi">
                           <el-input v-model="ruleForm.chanpinZhongzi"
                                     placeholder="种子" readonly></el-input>
                       </el-form-item>
                   </div>
               </el-col>
               <el-col :span="12">
                   <el-form-item class="input" v-if="type!='info'"  label="肥料" prop="chanpinFeiliao">
                       <el-input v-model="ruleForm.chanpinFeiliao"
                                 placeholder="肥料" clearable  :readonly="ro.chanpinFeiliao"></el-input>
                   </el-form-item>
                   <div v-else>
                       <el-form-item class="input" label="肥料" prop="chanpinFeiliao">
                           <el-input v-model="ruleForm.chanpinFeiliao"
                                     placeholder="肥料" readonly></el-input>
                       </el-form-item>
                   </div>
               </el-col>
               <el-col :span="12">
                   <el-form-item class="input" v-if="type!='info'"  label="农药" prop="chanpinNongyao">
                       <el-input v-model="ruleForm.chanpinNongyao"
                                 placeholder="农药" clearable  :readonly="ro.chanpinNongyao"></el-input>
                   </el-form-item>
                   <div v-else>
                       <el-form-item class="input" label="农药" prop="chanpinNongyao">
                           <el-input v-model="ruleForm.chanpinNongyao"
                                     placeholder="农药" readonly></el-input>
                       </el-form-item>
                   </div>
               </el-col>
               <el-col :span="12">
                   <el-form-item class="input" v-if="type!='info'"  label="数量" prop="chanpinNumber">
                       <el-input v-model="ruleForm.chanpinNumber"
                                 placeholder="数量" clearable  :readonly="ro.chanpinNumber"></el-input>
                   </el-form-item>
                   <div v-else>
                       <el-form-item class="input" label="数量" prop="chanpinNumber">
                           <el-input v-model="ruleForm.chanpinNumber"
                                     placeholder="数量" readonly></el-input>
                       </el-form-item>
                   </div>
               </el-col>
               <el-col :span="12">
                   <el-form-item class="input" v-if="type!='info'"  label="单位" prop="chanpinDanwei">
                       <el-input v-model="ruleForm.chanpinDanwei"
                                 placeholder="单位" clearable  :readonly="ro.chanpinDanwei"></el-input>
                   </el-form-item>
                   <div v-else>
                       <el-form-item class="input" label="单位" prop="chanpinDanwei">
                           <el-input v-model="ruleForm.chanpinDanwei"
                                     placeholder="单位" readonly></el-input>
                       </el-form-item>
                   </div>
               </el-col>
                <el-col :span="24">
                    <el-form-item v-if="type!='info'"  class="input" label="生产日期" prop="chanpinTime">
                        <el-date-picker
                                value-format="yyyy-MM-dd"
                                v-model="ruleForm.chanpinTime"
                                type="date"
                                placeholder="生产日期"
                                :disabled="ro.chanpinTime">
                        </el-date-picker>
                    </el-form-item>
                    <div v-else>
                        <el-form-item v-if="ruleForm.chanpinTime" label="生产日期" prop="chanpinTime">
                            <span v-html="ruleForm.chanpinTime"></span>
                        </el-form-item>
                    </div>
                </el-col>

               <el-col :span="12">
                   <el-form-item class="input" v-if="type!='info'"  label="保质期" prop="chanpinBaozhi">
                       <el-input v-model="ruleForm.chanpinBaozhi"
                                 placeholder="保质期" clearable  :readonly="ro.chanpinBaozhi"></el-input>
                   </el-form-item>
                   <div v-else>
                       <el-form-item class="input" label="保质期" prop="chanpinBaozhi">
                           <el-input v-model="ruleForm.chanpinBaozhi"
                                     placeholder="保质期" readonly></el-input>
                       </el-form-item>
                   </div>
               </el-col>
            </el-row>
            <el-form-item class="btn">
                <el-button v-if="type!='info'" type="primary" class="btn-success" @click="onSubmit">提交</el-button>
                <el-button v-if="type!='info'" class="btn-close" @click="back()">取消</el-button>
                <el-button v-if="type=='info'" class="btn-close" @click="back()">返回</el-button>
            </el-form-item>
        </el-form>
    </div>
</template>
<script>
    import styleJs from "../../../utils/style.js";
    // 数字，邮件，手机，url，身份证校验
    import { isNumber,isIntNumer,isEmail,isPhone, isMobile,isURL,checkIdCard } from "@/utils/validate";
    export default {
        data() {
            return {
                addEditForm:null,
                id: '',
                type: '',
                sessionTable : "",//登录账户所在表名
                role : "",//权限
                userId:"",//当前登录人的id
                ro:{
                    chanpinUuidNumber: false,
                    chanpinName: false,
                    chanpinTypes: false,
                    chanpinPhoto: false,
                    chanpinZhongzhi: false,
                    chanpinJiagong: false,
                    chanpinYunshu: false,
                    chanpinXiaoshou: false,
                    chanpinYuancailiao: false,
                    chanpinZhongzi: false,
                    chanpinFeiliao: false,
                    chanpinNongyao: false,
                    chanpinNumber: false,
                    chanpinDanwei: false,
                    chanpinTime: false,
                    chanpinBaozhi: false,
                },
                ruleForm: {
                    chanpinUuidNumber: new Date().getTime(),
                    chanpinName: '',
                    chanpinTypes: '',
                    chanpinPhoto: '',
                    chanpinZhongzhi: '',
                    chanpinJiagong: '',
                    chanpinYunshu: '',
                    chanpinXiaoshou: '',
                    chanpinYuancailiao: '',
                    chanpinZhongzi: '',
                    chanpinFeiliao: '',
                    chanpinNongyao: '',
                    chanpinNumber: '',
                    chanpinDanwei: '',
                    chanpinTime: '',
                    chanpinBaozhi: '',
                },
                chanpinTypesOptions : [],
                rules: {
                   chanpinUuidNumber: [
                              { required: true, message: '追溯码不能为空', trigger: 'blur' },
                          ],
                   chanpinName: [
                              { required: true, message: '产品名称不能为空', trigger: 'blur' },
                          ],
                   chanpinTypes: [
                              { required: true, message: '产品类型不能为空', trigger: 'blur' },
                              {  pattern: /^[1-9][0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                   chanpinPhoto: [
                              { required: true, message: '产品图片不能为空', trigger: 'blur' },
                          ],
                   chanpinZhongzhi: [
                              { required: true, message: '种植企业不能为空', trigger: 'blur' },
                          ],
                   chanpinJiagong: [
                              { required: true, message: '加工企业不能为空', trigger: 'blur' },
                          ],
                   chanpinYunshu: [
                              { required: true, message: '运输企业不能为空', trigger: 'blur' },
                          ],
                   chanpinXiaoshou: [
                              { required: true, message: '销售企业不能为空', trigger: 'blur' },
                          ],
                   chanpinYuancailiao: [
                              { required: true, message: '主要原材料不能为空', trigger: 'blur' },
                          ],
                   chanpinZhongzi: [
                              { required: true, message: '种子不能为空', trigger: 'blur' },
                          ],
                   chanpinFeiliao: [
                              { required: true, message: '肥料不能为空', trigger: 'blur' },
                          ],
                   chanpinNongyao: [
                              { required: true, message: '农药不能为空', trigger: 'blur' },
                          ],
                   chanpinNumber: [
                              { required: true, message: '数量不能为空', trigger: 'blur' },
                              {  pattern: /^[1-9][0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                   chanpinDanwei: [
                              { required: true, message: '单位不能为空', trigger: 'blur' },
                          ],
                   chanpinTime: [
                              { required: true, message: '生产日期不能为空', trigger: 'blur' },
                          ],
                   chanpinBaozhi: [
                              { required: true, message: '保质期不能为空', trigger: 'blur' },
                              {  pattern: /^[1-9][0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                }
            };
        },
        props: ["parent"],
        computed: {
        },
        created() {
            //获取当前登录用户的信息
            this.sessionTable = this.$storage.get("sessionTable");
            this.role = this.$storage.get("role");
            this.userId = this.$storage.get("userId");

            if (this.role != "管理员"){
            }
            this.addEditForm = styleJs.addStyle();
            this.addEditStyleChange()
            this.addEditUploadStyleChange()
            //获取下拉框信息
                this.$http({
                    url:`dictionary/page?page=1&limit=100&sort=&order=&dicCode=chanpin_types`,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        this.chanpinTypesOptions = data.data.list;
                    }
                });


        },
        mounted() {
        },
        methods: {
            // 下载
            download(file){
                window.open(`${file}`)
            },
            // 初始化
            init(id,type) {
                if (id) {
                    this.id = id;
                    this.type = type;
                }
                if(this.type=='info'||this.type=='else'){
                    this.info(id);
                }
                // 获取用户信息
                this.$http({
                    url:`${this.$storage.get("sessionTable")}/session`,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        var json = data.data;
                    } else {
                        this.$message.error(data.msg);
                    }
                });
            },
            // 多级联动参数
            info(id) {
                let _this =this;
                _this.$http({
                    url: `chanpin/info/${id}`,
                    method: 'get'
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        _this.ruleForm = data.data;
                    } else {
                        _this.$message.error(data.msg);
                    }
                });
            },
            // 提交
            onSubmit() {
                this.$refs["ruleForm"].validate(valid => {
                    if (valid) {
                        this.$http({
                            url:`chanpin/${!this.ruleForm.id ? "save" : "update"}`,
                            method: "post",
                            data: this.ruleForm
                        }).then(({ data }) => {
                            if (data && data.code === 0) {
                                this.$message({
                                    message: "操作成功",
                                    type: "success",
                                    duration: 1500,
                                    onClose: () => {
                                        this.parent.showFlag = true;
                                        this.parent.addOrUpdateFlag = false;
                                        this.parent.chanpinCrossAddOrUpdateFlag = false;
                                        this.parent.search();
                                        this.parent.contentStyleChange();
                                    }
                                });
                            } else {
                                this.$message.error(data.msg);
                            }
                        });
                    }
                });
            },
            // 获取uuid
            getUUID () {
                return new Date().getTime();
            },
            // 返回
            back() {
                this.parent.showFlag = true;
                this.parent.addOrUpdateFlag = false;
                this.parent.chanpinCrossAddOrUpdateFlag = false;
                this.parent.contentStyleChange();
            },
            //图片
            chanpinPhotoUploadChange(fileUrls){
                this.ruleForm.chanpinPhoto = fileUrls;
                this.addEditUploadStyleChange()
            },

            addEditStyleChange() {
                this.$nextTick(()=>{
                    // input
                    document.querySelectorAll('.addEdit-block .input .el-input__inner').forEach(el=>{
                        el.style.height = this.addEditForm.inputHeight
                        el.style.color = this.addEditForm.inputFontColor
                        el.style.fontSize = this.addEditForm.inputFontSize
                        el.style.borderWidth = this.addEditForm.inputBorderWidth
                        el.style.borderStyle = this.addEditForm.inputBorderStyle
                        el.style.borderColor = this.addEditForm.inputBorderColor
                        el.style.borderRadius = this.addEditForm.inputBorderRadius
                        el.style.backgroundColor = this.addEditForm.inputBgColor
                    })
                    document.querySelectorAll('.addEdit-block .input .el-form-item__label').forEach(el=>{
                        el.style.lineHeight = this.addEditForm.inputHeight
                        el.style.color = this.addEditForm.inputLableColor
                        el.style.fontSize = this.addEditForm.inputLableFontSize
                    })
                    // select
                    document.querySelectorAll('.addEdit-block .select .el-input__inner').forEach(el=>{
                        el.style.height = this.addEditForm.selectHeight
                        el.style.color = this.addEditForm.selectFontColor
                        el.style.fontSize = this.addEditForm.selectFontSize
                        el.style.borderWidth = this.addEditForm.selectBorderWidth
                        el.style.borderStyle = this.addEditForm.selectBorderStyle
                        el.style.borderColor = this.addEditForm.selectBorderColor
                        el.style.borderRadius = this.addEditForm.selectBorderRadius
                        el.style.backgroundColor = this.addEditForm.selectBgColor
                    })
                    document.querySelectorAll('.addEdit-block .select .el-form-item__label').forEach(el=>{
                        el.style.lineHeight = this.addEditForm.selectHeight
                        el.style.color = this.addEditForm.selectLableColor
                        el.style.fontSize = this.addEditForm.selectLableFontSize
                    })
                    document.querySelectorAll('.addEdit-block .select .el-select__caret').forEach(el=>{
                        el.style.color = this.addEditForm.selectIconFontColor
                        el.style.fontSize = this.addEditForm.selectIconFontSize
                    })
                    // date
                    document.querySelectorAll('.addEdit-block .date .el-input__inner').forEach(el=>{
                        el.style.height = this.addEditForm.dateHeight
                        el.style.color = this.addEditForm.dateFontColor
                        el.style.fontSize = this.addEditForm.dateFontSize
                        el.style.borderWidth = this.addEditForm.dateBorderWidth
                        el.style.borderStyle = this.addEditForm.dateBorderStyle
                        el.style.borderColor = this.addEditForm.dateBorderColor
                        el.style.borderRadius = this.addEditForm.dateBorderRadius
                        el.style.backgroundColor = this.addEditForm.dateBgColor
                    })
                    document.querySelectorAll('.addEdit-block .date .el-form-item__label').forEach(el=>{
                        el.style.lineHeight = this.addEditForm.dateHeight
                        el.style.color = this.addEditForm.dateLableColor
                        el.style.fontSize = this.addEditForm.dateLableFontSize
                    })
                    document.querySelectorAll('.addEdit-block .date .el-input__icon').forEach(el=>{
                        el.style.color = this.addEditForm.dateIconFontColor
                        el.style.fontSize = this.addEditForm.dateIconFontSize
                        el.style.lineHeight = this.addEditForm.dateHeight
                    })
                    // upload
                    let iconLineHeight = parseInt(this.addEditForm.uploadHeight) - parseInt(this.addEditForm.uploadBorderWidth) * 2 + 'px'
                    document.querySelectorAll('.addEdit-block .upload .el-upload--picture-card').forEach(el=>{
                        el.style.width = this.addEditForm.uploadHeight
                        el.style.height = this.addEditForm.uploadHeight
                        el.style.borderWidth = this.addEditForm.uploadBorderWidth
                        el.style.borderStyle = this.addEditForm.uploadBorderStyle
                        el.style.borderColor = this.addEditForm.uploadBorderColor
                        el.style.borderRadius = this.addEditForm.uploadBorderRadius
                        el.style.backgroundColor = this.addEditForm.uploadBgColor
                    })
                    document.querySelectorAll('.addEdit-block .upload .el-form-item__label').forEach(el=>{
                        el.style.lineHeight = this.addEditForm.uploadHeight
                        el.style.color = this.addEditForm.uploadLableColor
                        el.style.fontSize = this.addEditForm.uploadLableFontSize
                    })
                    document.querySelectorAll('.addEdit-block .upload .el-icon-plus').forEach(el=>{
                        el.style.color = this.addEditForm.uploadIconFontColor
                        el.style.fontSize = this.addEditForm.uploadIconFontSize
                        el.style.lineHeight = iconLineHeight
                        el.style.display = 'block'
                    })
                    // 多文本输入框
                    document.querySelectorAll('.addEdit-block .textarea .el-textarea__inner').forEach(el=>{
                        el.style.height = this.addEditForm.textareaHeight
                        el.style.color = this.addEditForm.textareaFontColor
                        el.style.fontSize = this.addEditForm.textareaFontSize
                        el.style.borderWidth = this.addEditForm.textareaBorderWidth
                        el.style.borderStyle = this.addEditForm.textareaBorderStyle
                        el.style.borderColor = this.addEditForm.textareaBorderColor
                        el.style.borderRadius = this.addEditForm.textareaBorderRadius
                        el.style.backgroundColor = this.addEditForm.textareaBgColor
                    })
                    document.querySelectorAll('.addEdit-block .textarea .el-form-item__label').forEach(el=>{
                        // el.style.lineHeight = this.addEditForm.textareaHeight
                        el.style.color = this.addEditForm.textareaLableColor
                        el.style.fontSize = this.addEditForm.textareaLableFontSize
                    })
                    // 保存
                    document.querySelectorAll('.addEdit-block .btn .btn-success').forEach(el=>{
                        el.style.width = this.addEditForm.btnSaveWidth
                        el.style.height = this.addEditForm.btnSaveHeight
                        el.style.color = this.addEditForm.btnSaveFontColor
                        el.style.fontSize = this.addEditForm.btnSaveFontSize
                        el.style.borderWidth = this.addEditForm.btnSaveBorderWidth
                        el.style.borderStyle = this.addEditForm.btnSaveBorderStyle
                        el.style.borderColor = this.addEditForm.btnSaveBorderColor
                        el.style.borderRadius = this.addEditForm.btnSaveBorderRadius
                        el.style.backgroundColor = this.addEditForm.btnSaveBgColor
                    })
                    // 返回
                    document.querySelectorAll('.addEdit-block .btn .btn-close').forEach(el=>{
                        el.style.width = this.addEditForm.btnCancelWidth
                        el.style.height = this.addEditForm.btnCancelHeight
                        el.style.color = this.addEditForm.btnCancelFontColor
                        el.style.fontSize = this.addEditForm.btnCancelFontSize
                        el.style.borderWidth = this.addEditForm.btnCancelBorderWidth
                        el.style.borderStyle = this.addEditForm.btnCancelBorderStyle
                        el.style.borderColor = this.addEditForm.btnCancelBorderColor
                        el.style.borderRadius = this.addEditForm.btnCancelBorderRadius
                        el.style.backgroundColor = this.addEditForm.btnCancelBgColor
                    })
                })
            },
            addEditUploadStyleChange() {
                this.$nextTick(()=>{
                    document.querySelectorAll('.addEdit-block .upload .el-upload-list--picture-card .el-upload-list__item').forEach(el=>{
                        el.style.width = this.addEditForm.uploadHeight
                        el.style.height = this.addEditForm.uploadHeight
                        el.style.borderWidth = this.addEditForm.uploadBorderWidth
                        el.style.borderStyle = this.addEditForm.uploadBorderStyle
                        el.style.borderColor = this.addEditForm.uploadBorderColor
                        el.style.borderRadius = this.addEditForm.uploadBorderRadius
                        el.style.backgroundColor = this.addEditForm.uploadBgColor
                    })
                })
            },
        }
    };
</script>
<style lang="scss">
.editor{
  height: 500px;

  & /deep/ .ql-container {
	  height: 310px;
  }
}
.amap-wrapper {
  width: 100%;
  height: 500px;
}
.search-box {
  position: absolute;
}
.addEdit-block {
	margin: -10px;
}
.detail-form-content {
	padding: 12px;
}
.btn .el-button {
  padding: 0;
}</style>

