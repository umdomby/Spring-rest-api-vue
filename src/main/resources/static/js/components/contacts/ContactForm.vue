<template>
    <div>
        <input type="text" placeholder="Write something" v-model="text" />
        <input type="button" value="Save" @click="save" />
    </div>
</template>

<script>
    function getIndex(list, id) {
        for (var i = 0; i < list.length; i++ ) {
            if (list[i].id === id) {
                return i
            }
        }

        return -1
    }

    export default {
        props: ['contacts', 'contactAttr'],
        data() {
            return {
                text: '',
                id: ''
            }
        },
        watch: {
            contactAttr(newVal, oldVal) {
                this.text = newVal.text
                this.id = newVal.id
            }
        },
        methods: {
            save() {
                const contact = { text: this.text }

                if (this.id) {
                    this.$resource('/contact{/id}').update({id: this.id}, contact).then(result =>
                        result.json().then(data => {
                            const index = getIndex(this.contacts, data.id)
                            this.contacts.splice(index, 1, data)
                            this.text = ''
                            this.id = ''
                        })
                    )
                } else {
                    this.$resource('/contact{/id}').save({}, contact).then(result =>
                        result.json().then(data => {
                            this.contacts.push(data)
                            this.text = ''
                        })
                    )
                }
            }
        }
    }
</script>

<style>

</style>
