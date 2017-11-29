<template>
  <div class="hello">
    <h1>{{ msg }}</h1>
    <el-select v-model="value" placeholder="请选择">
      <el-option
        v-for="item in classes"
        :key="item.id"
        :label="item.teacher"
        :value="item.teacher">
      </el-option>
    </el-select>
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
      }
    }
  }
}
</script>
<style>
.el-form {
  margin-top: 20px;
  width: 400px;
}
</style>

