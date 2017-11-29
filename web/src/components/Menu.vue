<template>
  <el-menu>
      <router-link 
        class="menu-link"
        v-for='page in pages' 
        key='$index' 
        :to="page.router" >
        <el-menu-item index='$index'>
          <div class="menu-content">{{page.name}}</div>
        </el-menu-item>
      </router-link>
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
.menu-link {
  text-decoration: none;
}
.menu-content {
  color: #000;
}
</style>

