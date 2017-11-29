<template>
  <el-menu>
    <el-menu-item v-for='page in pages' key='$index' >
      <router-link 
        :to="page.router" >
        {{page.name}}
      </router-link>
    </el-menu-item>
  </el-menu>
</template>
<script>
export default {
  name: 'Menu',
  data: function () {
    return {
      pages: [
        {
          router: '/',
          name: 'Todo'
        }, {
          router: '/componentdemo',
          name: 'Componentdemo'
        }, {
          router: '/tree',
          name: 'Tree'
        }, {
          router: '/canvas',
          name: 'Canvas'
        }
      ]
    }
  }
}
</script>
<style>
.el-menu {
  height: 100%;
}
</style>

