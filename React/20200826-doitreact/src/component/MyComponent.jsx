import React from 'react'

function MyComponent(){
    render(){
        const name = this.props.name;
        return <span>{name}</span>;
    }
}

export default MyComponent
