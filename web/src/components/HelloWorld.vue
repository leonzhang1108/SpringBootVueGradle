<template>
  <div class="hello">
    <h1>{{ msg }}</h1>
    <el-row :gutter="20">
      <el-col :span="6">
        <el-form :model="form" label-width="80px" ref="classForm" :rules="rules">
          <el-form-item label="teacher:" prop="teacher">
            <el-input v-model="form.teacher"></el-input>
          </el-form-item>
          <el-form-item label="classNo:" prop="classNo">
            <el-input v-model="form.classNo"></el-input>
          </el-form-item>
          <el-form-item label="floor:">
            <el-input-number v-model="form.floor" :min="1" :max="10" />
          </el-form-item>
          <el-form-item>
            <el-button type="primary" @click="onSubmit">立即创建</el-button>
          </el-form-item>
        </el-form>
      </el-col>
      <el-col :span="6">
        <el-select v-model="value" placeholder="班级">
          <el-option
            v-for="item in classes"
            :key="item.id"
            :label="item.teacher"
            :value="item.teacher">
          </el-option>
        </el-select>
      </el-col>
      <el-col :span="6">
        <el-upload
          class="upload-demo"
          action="/file/upload"
          :on-preview="handlePreview"
          :on-remove="handleRemove"
          multiple
          :limit="3"
          :on-exceed="handleExceed"
          :file-list="fileList">
          <el-button size="small" type="primary">点击上传</el-button>
          <div slot="tip" class="el-upload__tip">只能上传jpg/png文件，且不超过500kb</div>
        </el-upload>
      </el-col>
    </el-row>



  </div>
</template>

<script>
import fetch from "util/fetch";
export default {
  name: "HelloWorld",
  mounted() {
    this.getClasses()
  },
  methods: {
    getClasses() {
      fetch
        .get("/api/class/info")
        .then(res => {
          this.classes = res
        })
        .catch(err => console.log(err))
    },
    onSubmit() {
      this.$refs["classForm"].validate(valid => {
        console.log(this.form)
        if(valid) {
          fetch
            .post("/api/class/save", this.form)
            .then(res => {
              this.$message('插入成功')
              this.$refs["classForm"].resetFields()
              this.getClasses()
            })
            .catch(err => console.log(err))
        } else {
          return false
        }
      })
    },

    handleRemove(file, fileList) {
      console.log(file, fileList);
    },
    handlePreview(file) {
      console.log(file);
      console.log(this.fileList.length)
    },
    handleExceed(files, fileList) {
      this.$message.warning(`当前限制选择 3 个文件，本次选择了 ${files.length} 个文件，共选择了 ${files.length + fileList.length} 个文件`);
    }
  },
  data() {
    return {
      msg: "Welcome to Vue.js App",
      classes: [],
      value: '',
      form: {
        teacher: '',
        classNo: '',
        floor: '',
      },
      rules: {
        teacher: [{ required: true, message: '请输入教师名称', trigger: 'blur' }],
        classNo: [{ required: true, message: '请输入教室名称', trigger: 'blur' }]
      },
      fileList: []
    }
  }
}
</script>
<style>
.el-col {
  margin-top: 20px;
}
.el-form {
  width: 100%;
}
.el-select {
  width: 100%;
}
</style>

