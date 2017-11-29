<template>
  <el-container id="app">
    <el-aside width="200px">
      <MyMenu/>
    </el-aside>
    <el-container>
      <el-header>
        <Tabs :tabs='tabs' :currentPath='currentPath'/>
      </el-header>
      <el-main>
        <keep-alive>
          <router-view/>
        </keep-alive>
      </el-main>
    </el-container>
  </el-container>
</template>

<script>
import MyMenu from "@/components/Menu";
import Tabs from "@/components/Tabs";
export default {
  name: "app",
  data: function() {
    return {
      tabs: [],
      currentPath: ""
    };
  },
  components: {
    MyMenu,
    Tabs
  },
  watch: {
    $route(to, from) {
      this.currentPath = to.path;
      this.tabs.push({
        name: to.name
      });
    }
  }
};
</script>

<style>
body,
html {
  margin: 0;
  padding: 0;
  height: 100%;
}
.el-container {
  height: 100%;
}
.el-header, .el-footer {
  background-color: #B3C0D1;
  color: #333;
  text-align: left;
  line-height: 60px;
}

.el-aside {
  background-color: #D3DCE6;
  color: #333;
  text-align: center;
}
</style>
