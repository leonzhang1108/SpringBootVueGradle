<template>
  <div class="hello">
    <h1>{{ msg }}</h1>
    <el-select v-model="value" placeholder="请选择">
      <el-option
        v-for="item in classes"
        :key="item.id"
        :label="item.teacher"
        :value="item.id">
      </el-option>
    </el-select>
  </div>
</template>

<script>
import fetch from "util/fetch";
export default {
  name: "HelloWorld",
  mounted() {
    fetch
      .get("/api/app/info")
      .then(res => {
        this.classes = res
      })
      .catch(err => console.log(err));
  },
  data() {
    return {
      msg: "Welcome to Your Vue.js Appgggg",
      classes: [],
      value: ''
    };
  }
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
</style>
